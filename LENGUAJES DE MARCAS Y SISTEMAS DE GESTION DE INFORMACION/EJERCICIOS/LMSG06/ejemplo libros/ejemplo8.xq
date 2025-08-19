for $libro in doc("libros.xml")//libros/libro
where not($libro/versionElectronica)
return 
<libro>{$libro/titulo}</libro>
