(:El número de artistas nacidos antes de 1600:)
count(
  for $x in doc("artistas.xml")//artistas/artista
where $x/nacimiento < 1600
return $x
)