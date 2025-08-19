for $libro in doc("libros.xml")//libros/libro
where $libro/editorial ="O'Reilly"
order by $libro/titulo
return 
<ul>
  <li>{$libro/titulo/text()}</li>
</ul>
