<template>
    <div class="select-container">
      <ion-label>Extras</ion-label>
      <div class="custom-select">
        <div class="selected-option" @click="toggleDropdown">
          <span v-if="!selectedOptions.length">Select Options</span>
          <span v-else>{{ selectedOptions.join(', ') }}</span>
        </div>
        <div class="dropdown-options" v-if="dropdownOpen">
          <div
            class="dropdown-option"
            v-for="option in options"
            :key="option.value"
            @click="selectOption(option)"
          >
            <i :class="option.iconClass"></i>
            <span>{{ option.text }}</span>
          </div>
        </div>
      </div>
    </div>
  </template>

<script lang="ts">
import { defineComponent, ref } from 'vue';

export default defineComponent({
  name: 'CustomSelect',
  setup() {
    const dropdownOpen = ref(false);
    const selectedOptions = ref<string[]>([]);
    const options = ref([
      { value: 'option1', text: 'Balcony', iconClass: 'bi bi-house' },
      { value: 'option2', text: 'Air Condition', iconClass: 'bi bi-snow' },
      { value: 'option3', text: 'Bathroom', iconClass: 'bi bi-droplet' },
      { value: 'option4', text: 'Whirlpool', iconClass: 'bi bi-star' },
    ]);

    const toggleDropdown = () => {
      dropdownOpen.value = !dropdownOpen.value;
    };

    const selectOption = (option: { value: string; text: string }) => {
      if (selectedOptions.value.includes(option.text)) {
        selectedOptions.value = selectedOptions.value.filter(
          (opt) => opt !== option.text
        );
      } else {
        selectedOptions.value.push(option.text);
      }
      dropdownOpen.value = false;
    };

    return { dropdownOpen, selectedOptions, options, toggleDropdown, selectOption };
  },
});
</script>

<style>
.select-container {
  position: relative;
}

.custom-select {
  border: 1px solid #ccc;
  border-radius: 12px;
  padding: 8px;
  cursor: pointer;
  background-color: #f0f0f0;
  width: 100%;
}

.custom-select {
    --background: #847e71;
    --background-activated: #6e685e;
    --background-focused: #6e685e;
    --background-hover: #6e685e;
    --color: #ffffff;
}

.selected-option {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.dropdown-options {
  position: absolute;
  top: 100%;
  left: 0;
  right: 0;
  border: 1px solid #ccc;
  background-color: white;
  z-index: 1000;
  width: 100%;
  top: 100%;
  border-radius: 12px;
}

.dropdown-option {
  padding: 8px;
  display: flex;
  align-items: center;
}

.dropdown-option i {
  margin-right: 8px;
}



</style>