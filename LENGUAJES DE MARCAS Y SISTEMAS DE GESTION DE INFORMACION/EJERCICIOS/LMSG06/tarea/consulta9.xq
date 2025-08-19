(:Marca y modelo de las impresoras con tamaño A3 como único tamaño:)
for $x in doc("impresoras.xml")//impresoras/impresora
where count($x/tamaño) = 1 and $x/tamaño = "A3"
return 
<impresora>
  <marca>{$x/marca/text()}</marca>
  <modelo>{$x/modelo/text()}</modelo>
</impresora>