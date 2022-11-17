<template lang="">
   <button :type="type" :name="name" :id="id" class="border rounded-md px-3 py-2 mt-4 bg-slate-300">{{ text }}</button>
</template>
<script>
export default {
   name: 'BaseButton',
   props: {
      type: {type: String, required: true},
      text:{type: String, default: () => 'Label'},
      id:{type: String, required: true},
      name:{type: String, required: true},
   },
}
</script>
<style lang="">
   
</style>