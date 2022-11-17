<template lang="">
   <nav class="p-4 flex flex-row justify-around border-solid border-gray-300 border-b">
      <NavBarItem to="/" text="Home"/>
      <NavBarItem to="/register" text="Register"/>
      <NavBarItem to="/login" text="Login"/>
      <NavBarItem to="/help" text="Help"/>
      <NavBarItem to="/imprint" text="Imprint"/>
   </nav>
   <router-view/>
</template>

<script>
import NavBarItem from '@/components/atoms/NavBarItem.vue';

export default {
   name: 'NavBar',
   components: {
      NavBarItem,
   }
}
</script>