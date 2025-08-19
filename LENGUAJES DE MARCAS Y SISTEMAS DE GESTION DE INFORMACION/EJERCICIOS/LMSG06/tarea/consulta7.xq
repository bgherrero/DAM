(:Marca y modelo de las impresoras con más de un tamaño:)
for $x in doc("impresoras.xml")//impresoras/impresora
where count($x/tamaño) > 1
return 
<impresora>
  <marca>{$x/marca/text()}</marca>
  <modelo>{$x/modelo/text()}</modelo>
</impresora>