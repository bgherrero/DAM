for $libro in doc("libros.xml")//libros/libro
where $libro/versionElectronica
return 
<libro>{$libro/titulo, $libro/editorial}</libro>
