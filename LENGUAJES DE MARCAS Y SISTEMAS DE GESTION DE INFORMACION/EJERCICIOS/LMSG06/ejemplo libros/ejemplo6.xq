for $libro in doc("libros.xml")//libros/libro
where count($libro/autor) > 1
return 
<libro>{$libro/titulo, $libro/editorial}</libro>
