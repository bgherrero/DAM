for $libro in doc("libros.xml")//libros/libro
where $libro/@publicacion ="2002"
return 
<libro>{$libro/titulo, $libro/editorial}</libro>
