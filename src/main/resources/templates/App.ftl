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
                                    <RouterLink to="/${firstrouter}/${secondrouter}" active-class="active">${secondrouter}
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

</style>