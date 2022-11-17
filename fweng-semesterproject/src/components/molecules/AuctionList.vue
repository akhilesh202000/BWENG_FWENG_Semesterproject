<template lang="">
   <div>
      <h2>Auction List</h2>
      <div class="flex flex-row">
         <BaseAuction
            class="mx-5" 
            v-for="(auction, index) in auctions"
            v-bind:id="auction.id"
            v-bind:name="auction.name"
            :key="index"/>
      </div>      
   </div>
</template>
<script>
import BaseAuction from '../atoms/BaseAuction.vue';

export default {
   name: 'AuctionList',
   components: { BaseAuction },
   data: () => ({
      auctions: [
         { id: 1, name: 'auction1'},
         { id: 2, name: 'auction2'},
         { id: 3, name: 'auction3'},
      ]
   })
}
</script>
<style lang="">
</style>