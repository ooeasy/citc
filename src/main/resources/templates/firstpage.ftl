<template>
    <p>${firstrouter}</p>
    <div class="page">
        <!-- 页面内容 -->
        <RouterView/>
    </div>
</template>
<script setup lang="ts">
    import {RouterLink, RouterView} from 'vue-router'
</script>

<style scoped>
    .page {
        width: 1200px;
        height: 600px;
    }
    p {
        color: lightgray;
    }
</style>