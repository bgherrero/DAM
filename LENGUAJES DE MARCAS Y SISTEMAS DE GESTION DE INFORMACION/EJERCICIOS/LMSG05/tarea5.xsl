<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="artistas">
    <html>
      <head><title>Tabla de artistas</title></head>
      <body>
        <table border="1">
          <tr>
           <th>Código</th>
           <th>Nombre</th>
           <th>Año de nacimiento</th>
           <th>Año de fallecimiento</th>
           <th>País</th>
           <th>Página web</th>
          </tr>
          <xsl:apply-templates select="artista">
            <xsl:sort select="nacimiento" data-type="number"/>
          </xsl:apply-templates>
        </table>
     </body>
    </html>
  </xsl:template>

  
 <xsl:template match="artista">
    <xsl:if test="nacimiento&gt;1500">
      <tr>
        <td><xsl:value-of select="@cod"/></td>
        <td><xsl:value-of select="nombreCompleto"/></td>
        <td><xsl:value-of select="nacimiento"/></td>
        <td><xsl:apply-templates select="fallecimiento"/></td>
        <td><xsl:value-of select="pais"/></td>
        <td><xsl:apply-templates select="fichaCompleta"/></td>
      </tr>
      </xsl:if>
  </xsl:template>
  
<xsl:template match="fallecimiento">
    <xsl:choose>
      <xsl:when test=".">
        <xsl:value-of select="."/>  
      </xsl:when>
      <xsl:otherwise>
        Desconocido 
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  
  <xsl:template match="fichaCompleta">
    <xsl:variable name="link">
        <xsl:value-of select="."/>
    </xsl:variable>
    <a href="{$link}">Saber más</a>
  </xsl:template>  
</xsl:stylesheet>
