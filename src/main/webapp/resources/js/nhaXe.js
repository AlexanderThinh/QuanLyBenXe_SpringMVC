/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const handleThemChuyenXe = (endpoint) => {
    let bienSo = document.querySelector('#bienSo')
    let loaiXeID = document.querySelector('#loaiXeID')
    let nhaXeID = document.querySelector('#nhaXeID')
    let tuyenXeID = document.querySelector('#tuyenXeID')
    let soGhe = document.querySelector('#soGhe')
    let gia = document.querySelector('#gia')
    let dichVu = document.querySelector('#dichVu')
    let gioXeChay = document.querySelector('#gioXeChay')
    let ngayDi = document.querySelector('input[name="ngayDi"]')
    let ngayVe = document.querySelector('input[name="ngayVe"]')
    
    let spinner = document.querySelector(`.mySpinnerThemCX`)
    spinner.style.display = 'block'
    let btnBooking = document.querySelector(`.btnThemCX`)
    btnBooking.style.display = 'none'
    
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            "bienSo": bienSo.value,
            "soGhe": soGhe.value,
            "gia": gia.value,
            "dichVu": dichVu.value,
            "loaiXeID": loaiXeID.value,
            "nhaXeID": nhaXeID.value,
            "gioXeChay": gioXeChay.value,
            "tuyenXeID": tuyenXeID.value,
            "ngayDi": ngayDi.value,
            "ngayVe": ngayVe.value
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => {
        spinner.style.display = 'none'
        btnBooking.style.display = 'block'
        alert('Thêm chuyến xe thành công')
        
        bienSo.value = soGhe.value = gia.value = dichVu.value = loaiXeID.value = gioXeChay.value = nhaXeID.value = tuyenXeID.value = ngayDi.value = ngayVe.value = ""
    })
}
