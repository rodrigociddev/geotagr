const { contextBridge, ipcRenderer } = require('electron');
const requests = require('./scripts/requests.js');
const { call } = require('function-bind');

contextBridge.exposeInMainWorld('electronAPI', {
  openFileDialog: async () => {
    return await ipcRenderer.invoke('dialog:openFile');
  },
  addMedia: (callback) => ipcRenderer.on('add-media', callback),
  addMediaDialog: () => ipcRenderer.send('open-add-media-dialog'),
  selectAll: (callback) => ipcRenderer.on('select-all', callback),
  unselectAll: (callback) => ipcRenderer.on('unselect-all', callback),
  deleteSelected: (callback) => ipcRenderer.on('delete-selected', callback),
  resetApp: (callback) => ipcRenderer.on('reset-app', callback),
  openProject: (callback) => ipcRenderer.on('open-project', (event_, mediaList)=>callback(mediaList))
})

contextBridge.exposeInMainWorld('requestsAPI', requests);
