# MH-Invest-Android-App

## Introducción

Se recomienda usar solamente en tablets para que el trabajo y funcionamiento sea optimo. 

Esta aplicación fue diseñada y programada en Android Studio con Java, fue hecha para una empresa de topografía y su función es colectar información de cámaras de inspección de alcantarillado. 

Permite tomar fotos del sitio y elementos de la cámara, permite obtener la goelocalizaición del punto donde esta ubicada adicionalmente esta permite descargar la información en un archivo .csv. 

## Descripción

Su página principal estś compuesta de dos botones, para abrir un nuevo formulario ó para abrir la base de datos. 

El nuevo formulario tiene 4 secciones las cuales fueron hechas como fragments, la primera sección es para tomar fotos estas se guardan en la galeria interna de la tablet, la segunda parte corresponde a la información general de la camara, la tercera parte corresponde a los elementos de la camara y la ultima árte corresponde a los tramos y tuberias internas de la camara (Cómo está conectada). Este formulario se puede guardar como nuevo o actualizar si se está trabajando sobre uno existente. Se almacena en una base de datos SQLite.

La página de base de datos consta de un buscador para buscar alguna cámara en especifico segun su PID o su nombre, luego hay una lista donde se muestran todas las filas que hay en la base de datos, se puede oprimir alguna para abrirla, se puede eliminar o se puede seleccionar todas para descargarlas en formato .csv.

## Imágenes

