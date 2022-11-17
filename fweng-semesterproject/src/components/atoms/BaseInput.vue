<!-- https://codepen.io/chris__sev/details/LYOyjY input design -->
<!-- https://dev.to/viniciuskneves/vue-custom-input-bk8#v-model-and-input -->

<template lang="">
  <label>
    {{label}}
  <br>
  <input
    :type="type"
    :name="name"
    v-model="model"
    class="rounded-md p-1 bg-light border border-gray-300"
  >
  <br>
  </label>
</template>
<script>
export default {
   name: 'BaseInput',
   props: {
      type: {type: String, default: 'text'},
      label:{type: String, required: true},
      placeholder: String,
   },
   computed: {
    name() {
      return this.label.toLowerCase();
    },
    model: {
      get() {
        return this.value;
      },
      set(value) {
        this.$emit('input', value);
      },
    },
    
  },
   
}
</script>
<style lang="">
   
</style>