(:Nombre y país de todos los artistas:)
for $x in doc("artistas.xml")//artistas/artista
return
<artistas>{$x/nombreCompleto, $x/pais}</artistas>