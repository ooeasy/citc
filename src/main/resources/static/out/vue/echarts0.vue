<template>
    <div class="echarts-box" id="test">
        <div id="myEcharts"></div>
    </div>
</template>

<script lang="ts">
    import * as echarts from "echarts";
    import {onMounted} from "vue";
    import {onUnmounted} from "vue";
    import axios from "axios";

    export default {
        setup() {
            //y轴数据
            let dataY = [10, 15, 25, 40, 60, 85, 115, 150, 190, 235, 285, 340, 400]
            //let dataY = [[1, 2], [3, 4], [5, 6]]
            //x轴坐标
            let dataX = ["默认一", "默认二", "默认三", "默认四", "默认五", "默认六", "默认七", "默认八", "默认九", "默认十", "默认十一", "默认十二"]
            //主题 dark light
            let theam: string = 'line'
            let typeX: string = "category"
            let typeY: string = "value"
            let typeSeries: string = 'dark'//图的种类：line bar pie scatter radar candlestick
            const interval = 1000;

            function testdata() {
                axios.get('http://127.0.0.1:8080/test')
                    .then(response => {
                        dataY = response.data.dataY
                        dataX = response.data.dataX
                    })
                    .catch(error => {
                        console.error('Error fetching data:', error);
                    })
                    .finally(() => {
                        initChart();
                    });
            }

            //声明定义一下echart
            let echart = echarts;

            onMounted(() => {
                testdata();
            });

            function initChart() {
                let dom = document.getElementById('myEcharts');
                let chart = echart.init(dom, theam);
                let Option = {
                    xAxis: {
                        type: typeX,//类目
                        data: dataX
                    },
                    tooltip: {
                        trigger: "axis"
                    },
                    yAxis: {
                        type: typeY,
                    },
                    series: [
                        {
                            type: typeSeries,
                            data: dataY,
                            smooth: true
                        }
                    ]
                }
                chart.setOption(Option);
                window.onresize = function () {
                    //自适应大小
                    chart.resize();
                };
            }
        }
    };
</script>
<style scoped>
    #myEcharts {
        width: 400px;
        height: 300px;
    }
</style>