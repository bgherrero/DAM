(:Una lista HTML con el nombre de los artistas nacidos en España.:)
for $x in doc("artistas.xml")//artistas/artista
where $x/pais = "España"
return 
<ul>
  <li>{$x/nombreCompleto/text()}</li>
</ul>