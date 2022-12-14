<template lang="">
   <div v-if="role == 'user'||role == 'admin'">
      <h2>Product List</h2>
      <div class="flex flex-row">
         <BaseProduct
            class="mx-5" 
            v-for="(product, index) in products"
            v-bind:id="product.id"
            v-bind:name="product.name"
            :key="index"/>
      </div>
   </div>
</template>
<script>
import BaseProduct from '../atoms/BaseProduct.vue';

export default {
   name: 'ProductList',
   components: { BaseProduct },
   data: () => ({
      products: [
         { id: 1, name: 'product1'},
         { id: 2, name: 'product2'},
         { id: 3, name: 'product3'},
      ],
      role: localStorage.getItem('role')
   })
}
</script>
<style lang="">
</style>