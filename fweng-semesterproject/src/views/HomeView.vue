<template>
   <div class="m-4">
      <ProductList/>
      <AuctionList/>
      <input type="button" @click="getProducts" value="getProducts">
   </div>
</template>
<script>
import axios from 'axios';
import ProductList from '@/components/molecules/ProductList.vue';
import AuctionList from '@/components/molecules/AuctionList.vue';

export default {
   name: 'HomeView',
   components: { ProductList, AuctionList },
   data: () => ({
      products: {
         values: {id: '', email: ''},
      }
   }),
   methods: {
     async getProducts() {
         let response= await axios.get("http://localhost:8080/auctions");
         console.log(response);
      }
   }

}
</script>
<style lang="">
</style>