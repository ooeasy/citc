<template>
    <div class="container">
        <div class="left-side">
            <nav>
                <ul>
                                            <li>
                            <RouterLink to="/first" active-class="active">first</RouterLink>
                        </li>
                        <ul>
                                <li>
                                    <RouterLink to="/first/add" active-class="active">add
                                    </RouterLink>
                                </li>
                                <li>
                                    <RouterLink to="/first/delete" active-class="active">delete
                                    </RouterLink>
                                </li>
                                <li>
                                    <RouterLink to="/first/select" active-class="active">select
                                    </RouterLink>
                                </li>
                        </ul>
                        <li>
                            <RouterLink to="/second" active-class="active">second</RouterLink>
                        </li>
                        <ul>
                                <li>
                                    <RouterLink to="/second/add" active-class="active">add
                                    </RouterLink>
                                </li>
                                <li>
                                    <RouterLink to="/second/delete" active-class="active">delete
                                    </RouterLink>
                                </li>
                                <li>
                                    <RouterLink to="/second/select" active-class="active">select
                                    </RouterLink>
                                </li>
                        </ul>
                        <li>
                            <RouterLink to="/third" active-class="active">third</RouterLink>
                        </li>
                        <ul>
                                <li>
                                    <RouterLink to="/third/a" active-class="active">a
                                    </RouterLink>
                                </li>
                                <li>
                                    <RouterLink to="/third/b" active-class="active">b
                                    </RouterLink>
                                </li>
                        </ul>
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