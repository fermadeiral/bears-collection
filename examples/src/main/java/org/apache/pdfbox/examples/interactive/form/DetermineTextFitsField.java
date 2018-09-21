/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.pdfbox.examples.interactive.form;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

/**
 * Determine if text length fits the field.
 * 
 * This sample builds on the form generated by @link CreateSimpleForm so you need to run that first.
 * 
 */
public final class DetermineTextFitsField
{
    private DetermineTextFitsField()
    {
    }

    public static void main(String[] args) throws IOException
    {
        try (PDDocument document = PDDocument.load(new File("target/SimpleForm.pdf")))
        {
            PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
            
            // Get the field and the widget associated to it.
            // Note: there might be multiple widgets
            PDField field = acroForm.getField("SampleField");
            PDAnnotationWidget widget = field.getWidgets().get(0);
            
            // Get the width of the fields box
            float widthOfField = widget.getRectangle().getWidth();
            
            // Get the font and the font size setting
            // This is currently a little awkward and needs improvement to have a better API
            // for that. In many cases the string will be built like that:
            //    /Helv 12 Tf 0 g
            // We could use PDFStreamParser to do the parsing. For the sample we split the
            // string.
            String defaultAppearance = ((PDTextField) field).getDefaultAppearance();
            String[] parts = defaultAppearance.split(" ");
            
            // Get the font name
            COSName fontName = COSName.getPDFName(parts[0].substring(1));
            float fontSize = Float.parseFloat(parts[1]);
            
            // Get the font resource.
            // First look up the font from the widgets appearance stream.
            // This will be the case if there is already a value.
            // If the value hasn't been set yet the font resource needs to be looked up from
            // the AcroForm default resources
            
            PDFont font = null;
            PDResources resources = widget.getNormalAppearanceStream().getResources();
            if (resources != null)
            {
                font = resources.getFont(fontName);
            }
            if (font == null)
            {
                font = acroForm.getDefaultResources().getFont(fontName);
            }
            
            String willFit = "short string";
            String willNotFit = "this is a very long string which will not fit the width of the widget";
            
            // calculate the string width at a certain font size
            float willFitWidth = font.getStringWidth(willFit) * fontSize / 1000;
            float willNotFitWidth = font.getStringWidth(willNotFit) * fontSize / 1000;
            
            assert willFitWidth < widthOfField;
            assert willNotFitWidth > widthOfField;
        }
    }

}
