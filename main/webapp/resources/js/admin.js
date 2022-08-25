/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const doanhThuStatsByMonth = (id, categoryLabels, categoryData) => {
    console.log(categoryLabels)
    console.log(categoryData)
 
    let backgroundColor = []
    let borderColor = []
    
    for (let i = 0; i < categoryData.length; i++) {
        let a = Math.floor(Math.random() * 255)
        let b = Math.floor(Math.random() * 255)
        let c = Math.floor(Math.random() * 255)

        backgroundColor.push(`rgb(${a}, ${b}, ${c})`)
        borderColor.push(`rgb(${a}, ${b}, ${c}), 0.7`)
    }
    
    const data = {
        labels: categoryLabels,
        datasets: [{
            label: 'Thống kê doanh thu tuyến xe theo tháng và quý trong năm',
            data: categoryData,
            backgroundColor: backgroundColor,
            borderColor: borderColor,
            borderWidth: 1
        }]
    }
    
    const config = {
        type: 'bar',
        data: data,
        options: {
          scales: {
            y: {
              beginAtZero: true
            }
          }
        },
      };
    
    let ctx = document.querySelector(`#${id}`).getContext('2d')
    const myChart = new Chart(ctx, config)
}


