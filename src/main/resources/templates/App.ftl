<template>
    <div class="container">
        <div class="left-side">
            <nav>
                <ul>
                    <#list firstRouterList as firstrouter>
                        <li>
                            <RouterLink to="/${firstrouter}" active-class="active">${firstrouter}</RouterLink>
                        </li>
                        <ul>
                            <#list secondRouterList[firstrouter_index] as secondrouter>
                                <li>
                                    <RouterLink to="/${firstrouter}/${secondrouter}"
                                                active-class="active">${secondrouter}
                                    </RouterLink>
                                </li>
                            </#list>
                        </ul>
                    </#list>
                </ul>
            </nav>
        </div>
        <div class="right-side">
            <!-- 右侧内容 -->
            <RouterView></RouterView>
        </div>
    </div>
</template>
<script setup lang="ts">
    import {RouterLink, RouterView} from 'vue-router'
</script>

<style scoped>

    .container {
        display: flex; /* 使用Flexbox布局 */
    }

    .left-side {
        width: 200px;
        color: #fff;
    }

    .right-side {
        flex: 1;
        padding: 5px;
    }

    nav ul,
    nav li {
        margin: 0;
        padding: 0;
        list-style: none;
    }

    nav ul {
        background-color: #f0f0f0; /* 背景颜色 */
        padding: 10px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 添加阴影 */
    }


</style>