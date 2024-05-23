<template>
    <#list typeList as type>
    <${type}${indexList[type_index]} id="${type}${indexList[type_index]}"></${type}${indexList[type_index]}>
</#list>
</template>
<script setup lang="ts">
    <#list typeList as type>
    import ${type}${indexList[type_index]} from '@/vue/${type}${indexList[type_index]}.vue';
    </#list>
</script>

<style scoped>
    <#list typeList as type>
    #${type}${indexList[type_index]}{
      width: ${widthList[type_index]}px;
      height: ${heightList[type_index]}px;
      margin-left: ${xList[type_index]}px;
      margin-top: ${yList[type_index]}px;
      }
    </#list>
</style>