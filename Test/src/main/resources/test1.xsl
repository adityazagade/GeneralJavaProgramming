<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text"/>
    <xsl:template match="/Item-Request">
        <xsl:for-each select="DisplayItem/Item/Specs">
            <xsl:for-each select="node()">
                <xsl:value-of select="name()"/>
            </xsl:for-each>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
