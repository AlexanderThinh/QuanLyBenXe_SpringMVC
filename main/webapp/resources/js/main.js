/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const testBtn = () => {
    console.log("Hello Thinh Alexander 123")
}

const listTuyenXe = (endpoint, endpoint2) => {
    fetch(endpoint, {
        method: 'get',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
        .then(data => {
            console.log(data)
            
            let listTuyenXeBlock = document.querySelector('#listTuyenXeBlock')
            let htmls = ''
            let i = 0;
            
            for(i = 0; i < data.length; i++) {
                htmls += `
                    <div class="row">
                        <a href="${endpoint2}/${data[i][0]}" class="col-12 col-md-5 col-sm-12 item_nha_xe">
                            <div class="img_nha_xe_wrap">
                                <img class="img-fluid img_nha_xe" src="${data[i][6]}" alt="${data[i][0]}"/>
                            </div>
                            <div class="tuyen_xe_info_container">
                                <h5>${data[i][1]} <i class="fa-solid fa-arrow-right"></i> ${data[i][2]}</h5>
                                <div class="nha_xe_info">
                                    <p><i class="fa-solid fa-location-dot"></i> ${data[i][3]} km</p>
                                    <p><i class="fa-solid fa-clock"></i> ${data[i][4]}</p>
                                    <p><i class="fa-solid fa-dollar-sign"></i> ${data[i][5]} VND</p>
                                </div>
                            </div>
                        </a>
                        <a href="${endpoint2}/${data[i+1][0]}" class="col-12 col-md-5 col-sm-12 item_nha_xe">
                            <div class="img_nha_xe_wrap">
                                <img class="img-fluid img_nha_xe" src="${data[i+1][6]}" alt="${data[i+1][0]}"/>
                            </div>
                            <div class="tuyen_xe_info_container">
                                <h5>${data[i+1][1]} <i class="fa-solid fa-arrow-right"></i> ${data[i+1][2]}</h5>
                                <div class="nha_xe_info">
                                    <p><i class="fa-solid fa-location-dot"></i> ${data[i+1][3]} km</p>
                                    <p><i class="fa-solid fa-clock"></i> ${data[i+1][4]}</p>
                                    <p><i class="fa-solid fa-dollar-sign"></i> ${data[i+1][5]} VND</p>
                                </div>
                            </div>
                        </a>
                    </div>  
                `
                i += 1
            }
    
            listTuyenXeBlock.innerHTML = htmls
    })
}

const tuyenXeDetail = (endpoint) => {
    fetch(endpoint, {
        method: 'get',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
        .then(data => {
            console.log(data)
    })
}

const addCommentNhaXe = (endpoint) => {
    let noiDung = document.querySelector('#commentContent')
    
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            "noiDung": noiDung.value
        }), 
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json())
        .then(data => {
            console.log(data)
    
            noiDung.value = ""
            
            let commentBlock = document.querySelector('#commentBlock')
            let htmls = ''
            commentBlock.innerHTML = `
                 <div class="row" style="margin: 20px 0">
                     <div class="col-md-1">
                         <img src="${data.user.avatar}" class="rounded-circle img-fluid" />
                     </div>
                     <div class="col-md-11 myDate">
                        <p class="text-primary">${data.user.username}</p>
                        <p>${data.noiDung}</p>
                        <i>${moment(data.createdDate).fromNow()}</i>
                     </div>
                 </div>  
             ` + commentBlock.innerHTML
    })
}

const themNhaXe = (endpoint) => {
    let tenNhaXe = document.querySelector('#tenNhaXe')
    let benXeId = document.querySelector('#benXeId')
    let inputNhanGiaoHang = document.querySelector('#inputNhanGiaoHang')
    
    console.log(tenNhaXe.value, benXeId.value)
    console.log(inputNhanGiaoHang.checked)
    
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            "tenNhaXe": tenNhaXe.value,
            "benXeID": benXeId.value,
            "nhanGiaoHang": inputNhanGiaoHang.checked == true ? 1 : 0
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
        .then(data => {
            alert('Thêm nhà xe thành công!')
            
            console.log(data)
            tenNhaXe.value = ""
            benXeId.value = ""
            inputNhanGiaoHang.checked = false
    })
}

const handleBlockNX = (nhaXeID, endpointKhoaNX) => {
    let nhaXeState = document.querySelector(`#nhaXe${nhaXeID} .tdActive`)
    
    if (nhaXeState.innerHTML == `<i class="fa-solid fa-check" style="color: green"></i>`) {
        fetch(`${endpointKhoaNX}/${nhaXeID}`, {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(res => {
            console.log(res.status)
            alert('Khóa thành công!')
            nhaXeState.innerHTML = `<i class="fa-solid fa-x" style="color: red"></i>`
        })
    } 
}

const handleUnBlockNX = (nhaXeID, endpointKhoaNX) => {
    let nhaXeState = document.querySelector(`#nhaXe${nhaXeID} .tdActive`)
    
    if (nhaXeState.innerHTML == `<i class="fa-solid fa-x" style="color: red"></i>`) {
        fetch(`${endpointKhoaNX}/${nhaXeID}`, {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(res => {
            console.log(res.status)
            alert('Mở khóa thành công!')
            nhaXeState.innerHTML = `<i class="fa-solid fa-check" style="color: green"></i>`
        })
    } 
}

const loadDSNhaXe = (endpoint, endpointKhoaNX) => {
    fetch(endpoint, {
        method: 'get',
        headers: {
            'Content-Type' : 'application/json'
        }
    }).then(res => res.json())
        .then(data => {
            let htmls = ''
            for (let i = 0; i < data.length; i++) {
                htmls += `
                    <tr id="nhaXe${data[i].id}">
                        <td>${data[i].tenNhaXe}</td>
                        <td class="tdActive">${data[i].active}</td>
                        <td class="tdGiaoHang">${data[i].giaoHang}</td>
                        <td class="tdButtonKhoaNX">
                            <button onclick="handleBlockNX(${data[i].id}, '${endpointKhoaNX}')" class="btn btn-warning">Khóa nhà xe</button>
                            <button onclick="handleUnBlockNX(${data[i].id}, '${endpointKhoaNX}')" class="btn btn-success">Mở khóa nhà xe</button>
                        </td>
                    </tr>
                `
            }

            let mainID = document.querySelector('#mainID') 
            mainID.innerHTML = htmls
            
            let spinner = document.getElementById('spinnerLoadProduct') 
            spinner.style.display = 'none'
            
            let tdActive = document.querySelectorAll(".tdActive")
            let tdButtonKhoaNX = document.querySelectorAll(".tdButtonKhoaNX")
            for(let i = 0; i < tdActive.length; i++) {
                if(tdActive[i].innerText == "true") {
                    tdActive[i].innerHTML = `<i class="fa-solid fa-check" style="color: green"></i>`
                } else {
                    tdActive[i].innerHTML = `<i class="fa-solid fa-x" style="color: red"></i>`
                }
            }
            
            let tdGiaoHang = document.querySelectorAll(".tdGiaoHang")
            tdGiaoHang.forEach(item => {
                if(item.innerText == "true") {
                    item.innerHTML = `<i class="fa-solid fa-check" style="color: green"></i>`
                } else {
                    item.innerHTML = `<i class="fa-solid fa-x" style="color: red"></i>`
                }
            })
    })
}

const ratingNhaXe = (endpoint) => {
    const container = document.querySelector('.rating')
    const items = document.querySelectorAll('.rating-item')

    if (container != null && items != null) {
        container.onclick = e => {
            const elClass = e.target.classList
            if(!elClass.contains('active')) {
                items.forEach(
                    item => item.classList.remove('active')
                )
                console.log(e.target.getAttribute('data-rate'))
                elClass.add('active')

                fetch(endpoint, {
                    method: 'post',
                    body: JSON.stringify({
                        "rate": e.target.getAttribute('data-rate')
                    }),
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).then(res => {
                    console.log(res.status)
                })
            }
        }
    }
}

//For booking
const showBookingDetail = (id) => {
    let bookingDetailBlock = document.querySelectorAll(`.bookingDetail${id}`)
    
    bookingDetailBlock.forEach(item => {
        if (item.style.display == 'none') {
            item.style.display = 'flex'
        } else {
            item.style.display = 'none'
        }
    })
}

const testSelectCheckBoxValue = (id, gia) => {
    let arrCheckBoxValue = []
    let checkBoxSoGhe = document.querySelectorAll(`input[name="checkBoxSoGhe${id}"]`)
    let quantityVe = document.querySelector(`.quantityVe${id}`)
    let totalMoney = document.querySelector(`.totalMoney${id}`)
    let countVe = 0
    
    checkBoxSoGhe.forEach(item => {
        if(item.checked == true) {
            if (countVe == 4) {
                alert('Chỉ được phép mua tối đa 4 vé trong một lần đặt vé')
                item.checked = false
            } else {
                countVe++
                arrCheckBoxValue.push(parseInt(item.value))
                quantityVe.innerText = countVe
                totalMoney.innerText = parseFloat(gia * countVe)    
            }
        }
        if(arrCheckBoxValue.length == 0) {
            totalMoney.innerText = quantityVe.innerText = 0
        }
    })
    console.log(arrCheckBoxValue)
}

const handleBooking = (endpoint, chuyenXeID, gia) => {
    let arrCheckBoxValue = []
    let checkBoxSoGhe = document.querySelectorAll(`input[name="checkBoxSoGhe${chuyenXeID}"]`)
    let bookingSuccess = false;
    let bookingName = document.querySelector(`input[name="bookingName${chuyenXeID}"]`)
    let bookingEmail = document.querySelector(`input[name="bookingEmail${chuyenXeID}"]`)
    let bookingPhone = document.querySelector(`input[name="bookingPhone${chuyenXeID}"]`)
    
    console.log(bookingName.value.trim())
    console.log(bookingEmail.value.trim())
    console.log(bookingPhone.value.trim())
    
    checkBoxSoGhe.forEach(item => {
        if(item.checked == true) {
            arrCheckBoxValue.push(parseInt(item.value))
        }
    })
    
    if(arrCheckBoxValue.length > 0) {
        if(bookingName.value.trim().length == 0 || bookingEmail.value.trim().length == 0 || bookingPhone.value.trim().length == 0) {
            alert('Vui lòng nhập đầy đủ thông tin cá nhân')
        } else {
            
            
            for(let i = 0; i < arrCheckBoxValue.length; i++) {
                fetch(`${endpoint}/${chuyenXeID}`, {
                    method: 'post',
                    body: JSON.stringify({
                        "gia": gia,
                        "soGhe": arrCheckBoxValue[i],
                        "loaiVeID": "1",
                        "receipient": bookingEmail.value.trim(),
                        "subject": "Thông tin đơn đặt vé xe", 
                        "content": "Cam ơn quy khach " + bookingName.value.trim() + " da dat ve. Thong\n\
                                    tin ve cua quy khach: So ghe: " + arrCheckBoxValue[i] + ". Gia: " + gia + " VND",
                    }),
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).then(res => res.json())
                    .then(data => {
                        bookingSuccess = true
                        console.log(data)
                        if(bookingSuccess == true && i == arrCheckBoxValue.length - 1) {
                            alert('Đặt vé thành công!')
                        } else if (bookingSuccess == false && i == arrCheckBoxValue.length - 1) {
                            alert('Đặt vé KHÔNG thành công!')
                        }
                })
            }
        }
    } else {
        alert('Bạn chưa chọn ghế!')
    }
}

//For giao hang
const handleShowInfoGiaoHang = (id) => {
    let infoGiaoHang = document.querySelectorAll(`.infoGiaoHang${id}`)
    
    infoGiaoHang.forEach(item => {
        if(item.style.display == 'none') {
            item.style.display = 'block'
        } else {
            item.style.display = 'none'
        }
    })
}

const handleChangeValueKL = (id) => {
    let totalMoneyDatHang = document.querySelector(`#totalMoneyDatHang${id}`)
    let inputKLHangHoa = document.querySelector(`input[name="KL-hang-hoa${id}"]`)
    let initMoney = 10000
    
    totalMoneyDatHang.innerText = parseFloat(initMoney * inputKLHangHoa.value)
}

const handleRegisterGiaoHang = (id, endpoint) => {
    let tenNguoiGui = document.querySelector(`input[name="name-nguoi-gui${id}"]`)
    let sdtNguoiGui = document.querySelector(`input[name="phone-nguoi-gui${id}"]`)
    let emailNguoiGui = document.querySelector(`input[name="email-nguoi-gui${id}"]`)
    let moTa = document.querySelector(`input[name="desc-hang-hoa${id}"]`)
    let soKi = document.querySelector(`input[name="KL-hang-hoa${id}"]`)
    let gia = 10000
    let tenNguoiNhan = document.querySelector(`input[name="name-nguoi-nhan${id}"]`)
    let sdtNguoiNhan = document.querySelector(`input[name="phone-nguoi-nhan${id}"]`)
    let emailNguoiNhan = document.querySelector(`input[name="email-nguoi-nhan${id}"]`)
    
    if (tenNguoiGui.value != "" && emailNguoiGui.value != "" && moTa.value != "" && 
            soKi.value != 0 && tenNguoiNhan.value != "" && emailNguoiNhan.value != "") {
        console.log(tenNguoiGui.value)
        console.log(sdtNguoiGui.value)
        console.log(emailNguoiGui.value)
        console.log(moTa.value)
        console.log(soKi.value)
        console.log(tenNguoiNhan.value)
        console.log(sdtNguoiNhan.value)
        console.log(emailNguoiNhan.value)
        
        fetch(`${endpoint}/${id}`, {
            method: 'post',
            body: JSON.stringify({
                "ten-nguoi-gui": tenNguoiGui.value,
                "phone-nguoi-gui": sdtNguoiGui.value,
                "email-nguoi-gui": emailNguoiGui.value,
                "ten-nguoi-nhan": tenNguoiNhan.value,
                "phone-nguoi-nhan": sdtNguoiNhan.value,
                "email-nguoi-nhan": emailNguoiNhan.value,
                "mo-ta": moTa.value,
                "so-ki": soKi.value,
                "gia": gia,
                "contentEmail": "Quy khach " + tenNguoiGui.value + " da dang ky giao hang thanh cong. Quy khach vui long xac\n\
                    nhan lai thong tin cua quy khach. Nguoi gui: " + tenNguoiGui.value + " Email nguoi gui: \n\
                    " + emailNguoiGui.value + " Ten nguoi nhan: " + tenNguoiNhan.value + " Email nguoi nhan \n\
                    " + emailNguoiNhan.value
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(res => res.json())
            .then(data => {
                alert('Đăng ký giao hàng thành công!')
                tenNguoiGui.value = emailNguoiGui.value = moTa.value = 
                soKi.value = tenNguoiNhan.value =  emailNguoiNhan.value = ""
                console.log(data)
        })
    } else {
        alert('Vui lòng điền đầy đủ thông tin!')
    }
}

