<template>
   <div class="view-container">   
      <h1 class="font-bold text-xl text-center">Register</h1>
      <RegisterForm/>
   </div>
</template>
<script>
import RegisterForm from '@/components/molecules/RegisterForm.vue';

export default {
    name: "RegisterView",
    components: { RegisterForm }
}
</script>
<style>
   
</style>