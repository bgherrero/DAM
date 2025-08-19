(:Modelo de las impresoras de tipo “láser":)
for $x in doc("impresoras.xml")//impresoras/impresora
where $x/@tipo = "láser"
return $x/modelo/text()