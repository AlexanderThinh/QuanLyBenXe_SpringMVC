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
    let ngayDi = document.querySelector('input[name="ngayDi"]')
    let ngayVe = document.querySelector('input[name="ngayVe"]')
    
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            "bienSo": bienSo.value,
            "soGhe": soGhe.value,
            "gia": gia.value,
            "dichVu": dichVu.value,
            "loaiXeID": loaiXeID.value,
            "nhaXeID": nhaXeID.value,
            "tuyenXeID": tuyenXeID.value,
            "ngayDi": ngayDi.value,
            "ngayVe": ngayVe.value
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => {
        console.log(res.status)
        alert('Thêm chuyến xe thành công')
        
        bienSo.value = soGhe.value = gia.value = dichVu.value = loaiXeID.value = nhaXeID.value = tuyenXeID.value = ngayDi.value = ngayVe.value = ""
    })
}
