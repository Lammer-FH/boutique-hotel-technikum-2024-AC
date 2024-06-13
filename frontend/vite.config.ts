import legacy from '@vitejs/plugin-legacy'
import vue from '@vitejs/plugin-vue'
import path from 'path'
//import { defineConfig } from 'vite' --> this comes with vanilla ionic generation, but throws an error
import { defineConfig } from 'vitest/config'
// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    legacy()
  ],
  resolve: {
    alias: {
      '@': path.resolve(__dirname, './src'),
      '@assets': path.resolve(__dirname, './src/assets'),
      '@components': path.resolve(__dirname, './src/components'),
    },
  },
  test: {
    globals: true,
    environment: 'jsdom'
  }
})