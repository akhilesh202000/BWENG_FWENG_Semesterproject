<template>
   <div class="relative h-96 w-full flex items-center justify-center">
      <div class="absolute transform left-1/2 -translate-x-1/2 w-96 h-full">
         <div class="relative text-center space-y-6 flex flex-col items-center">
            <h2 class="text-6xl font-serif text-gray-700 z-50">
               Home
            </h2>
            <ProductList />
            <AuctionList />
         </div>
      </div>
   </div>
</template>
<script>
import ProductList from '@/components/molecules/ProductList.vue';
import AuctionList from '@/components/molecules/AuctionList.vue';

export default {
   name: 'HomeView',
   components: { ProductList, AuctionList }
}
</script>
<style lang="">
</style>