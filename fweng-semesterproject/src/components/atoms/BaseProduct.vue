<template lang="">
   <div class="card">
         <div class="container">
         <img src="../../assets/products/beer.jpg" width="100">
         <h4 class="font-bold text-center">{{ id }}</h4>
         <p class="text-center">{{ name }}</p>
      </div>
   </div>
</template>
<script>
export default {
   name: 'BaseProduct',
   props: {
      id: {type: Number, required: true},
      name: {type: String, required: true},
   }
   
}
</script>
<style scoped>
.card {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  width: fit-content;
}

/* On mouse-over, add a deeper shadow */
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

/* Add some padding inside the card container */
.container {
  padding: 2px 16px;
}
</style>