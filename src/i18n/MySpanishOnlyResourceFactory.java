package i18n;

import java.util.Properties;

import org.openswing.swing.internationalization.java.Resources;
import org.openswing.swing.internationalization.java.ResourcesFactory;


/**
 * <p>Title: OpenSwing Framework</p>
 * <p>Description: Class for retrieve the collection of all internationalization properties:
 * translations, data/numeric/currency formats.
 * No translation is performed, date/numeric/currency formats are based on Spanish formats.</p>
 * <p>Copyright: Copyright (C) 2008 Javier Lopez Cacheiro</p>
 *
 * <p> This file is part of OpenSwing Framework.
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the (LGPL) Lesser General Public
 * License as published by the Free Software Foundation;
 *
 *                GNU LESSER GENERAL PUBLIC LICENSE
 *                 Version 2.1, February 1999
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the Free
 * Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 *       The author may be contacted at:
 *           alcachi@gmail.com</p>
 *
 * @author Javier Lopez Cacheiro
 * @version 1.0
 */
public class MySpanishOnlyResourceFactory extends ResourcesFactory {

  /** internationalization settings */
  private Resources resources = null;


  /**
   * Constructor.
   * @param currencySymbol currency symbol
   * @param additionalDictionary additional descriptions
   * @param showResourceNotFoundWarning warn when no resource key not found
   */
  public MySpanishOnlyResourceFactory(String currencySymbol,Properties additionalDictionary,boolean showResourceNotFoundWarning) {
    Properties dictionary = new Properties();

    dictionary.putAll(additionalDictionary);

    // grid...
    dictionary.setProperty("of","de");
    dictionary.setProperty("page","Page");
    dictionary.setProperty("Remove Filter","Quitar Filtro");
    dictionary.setProperty("This column is not sorteable","Esta columna no es ordenable");
    dictionary.setProperty("Sorting not allowed","Ordenado no permitido");
    dictionary.setProperty("Maximum number of sorted columns","N�mero m�ximo de columnas ordenadas");
    dictionary.setProperty("Sorting not applicable","Ordenado no aplicable");
    dictionary.setProperty("Selected Row","Fila Seleccionada");
    dictionary.setProperty("Selected Rows","Filas Seleccionadas");
    dictionary.setProperty("Cancel changes and reload data?","�Cancelar todos los cambios y recargar los datos?");
    dictionary.setProperty("Attention","Atenci�n");
    dictionary.setProperty("Loading data...","Cargando los datos...");
    dictionary.setProperty("Error while loading data","Ha ocurrido un error mientras se cargaban los datos");
    dictionary.setProperty("Loading Data Error","Error cargando los datos");
    dictionary.setProperty("Delete Rows?","�Borrar registro?");
    dictionary.setProperty("Delete Confirmation","Confirmaci�n de borrado");
    dictionary.setProperty("Error while deleting rows.","Ha ocurrido un error mientras se borraba el registro.");
    dictionary.setProperty("Deleting Error","Error Borrando");
    dictionary.setProperty("Error while saving","Ha ocurrido un error mientras se guardaba");
    dictionary.setProperty("Saving Error","Error Guardando");
    dictionary.setProperty("A mandatory column is empty.","Una columna obligatoria est� vac�a");
    dictionary.setProperty("Value not valid","Valor no v�lido");
    dictionary.setProperty("sorting conditions","Condiciones de ordenaci�n");
    dictionary.setProperty("filtering conditions","Condiciones de filtrado");
    dictionary.setProperty("filtering and sorting settings","Ajustes de ordenaci�n y filtrado");
    dictionary.setProperty("Filtering/Sorting data (CTRL+F)","Filtrado/Ordenaci�n de datos (CTRL+F)");
    dictionary.setProperty("upload file","Upload File");
    dictionary.setProperty("download file","Download File");

    dictionary.setProperty("Username","Usuario");
    dictionary.setProperty("Password","Contrase�a");
    dictionary.setProperty("Login","Ok");
    
    
    // export...
    dictionary.setProperty("grid export","Exportar Tabla");
    dictionary.setProperty("export","Exportar");
    dictionary.setProperty("exportmnemonic","X");
    dictionary.setProperty("column","Columna");
    dictionary.setProperty("sel.","Sel.");
    dictionary.setProperty("you must select at least one column","Debes seleccionar al menos una columna");
    dictionary.setProperty("columns to export","Columnas a exportar");
    dictionary.setProperty("export type","Formato de exportaci�n");

    // import...
    dictionary.setProperty("grid import","Importar Tabla");
    dictionary.setProperty("file to import","Fichero a importar");
    dictionary.setProperty("import","Importar");
    dictionary.setProperty("importmnemonic","M");
    dictionary.setProperty("columns to import","Columnas a importar");
    dictionary.setProperty("import type","Formato de importaci�n");
    dictionary.setProperty("error while importing data","Ha ocurrido un error mientras se importaban los datos");
    dictionary.setProperty("import completed","Importaci�n completada.");

    // quick filter...
    dictionary.setProperty("To value","A valor");
    dictionary.setProperty("Filter by","Filtrar por");
    dictionary.setProperty("From value","Desde valor");
    dictionary.setProperty("equals","igual");
    dictionary.setProperty("contains","contiene");
    dictionary.setProperty("starts with","comienza con");
    dictionary.setProperty("ends with","termina con");

    // select/deselect all
    dictionary.setProperty("select all","Seleccionar todo");
    dictionary.setProperty("deselect all","Deseleccionar todo");

    // copy/cut/paste
    dictionary.setProperty("copy","Copiar");
    dictionary.setProperty("copymnemonic","C");
    dictionary.setProperty("cut","Cortar");
    dictionary.setProperty("cutmnemonic","U");
    dictionary.setProperty("paste","Pegar");
    dictionary.setProperty("pastemnemonic","P");

    // lookup...
    dictionary.setProperty("Code is not correct.","El Codigo no es correcto.");
    dictionary.setProperty("Code Validation","Validaci�n del C�digo");
    dictionary.setProperty("Code Selection","Selecci�n del C�digo");

    // form...
    dictionary.setProperty("Confirm deliting data?","�Confirmaci�n de borrado de los datos?");
    dictionary.setProperty("Error while saving: incorrect data.","Error mientras se guardaba: datos incorrectos.");
    dictionary.setProperty("Error while validating data:","Error mientras se validaban los datos:");
    dictionary.setProperty("Validation Error","Error de validaci�n");
    dictionary.setProperty("Error on deleting:","Error borrando:");
    dictionary.setProperty("Error on Loading","Error cargando");
    dictionary.setProperty("Error while loading data:","Error mientras se cargaban los datos:");
    dictionary.setProperty("Error on setting value to the input control having the attribute name","Error estableciendo el valor del control de entrada que tiene el nombre de atributo");

    // toolbar buttons...
    dictionary.setProperty("Delete record (CTRL+D)","Borrar registro (CTRL+D)");
    dictionary.setProperty("Edit record (CTRL+E)","Editar registro (CTRL+E)");
    dictionary.setProperty("New record (CTRL+I)","Nuevo registro (CTRL+I)");
    dictionary.setProperty("Reload record/Cancel current operation (CTRL+Z)","Recargar registro/Cancelar operaci�n actual (CTRL+Z)");
    dictionary.setProperty("Save record (CTRL+S)","Guardar registro (CTRL+S)");
    dictionary.setProperty("Copy record (CTRL+C)","Copiar registro (CTRL+C)");
    dictionary.setProperty("Export record (CTRL+X)","Exportar registros (CTRL+X)");
    dictionary.setProperty("Import records (CTRL+M)","Importar registros (CTRL+M)");
    dictionary.setProperty("Load the first block of records","Cargar el primer bloque de registros");
    dictionary.setProperty("Select the previous row in grid","Selecccionar la fila anterior de la tabla");
    dictionary.setProperty("Select the next row in grid","Seleccionar la fila siguiente de la tabla");
    dictionary.setProperty("Load the previous block of records","Cargar el bloque anterior de registros");
    dictionary.setProperty("Load the next block of records","Cargar el siguiente bloque de registros");
    dictionary.setProperty("Load the last block of records","Cargar el �ltimo bloque de registros");

    dictionary.setProperty("Insert","Insertar");
    dictionary.setProperty("Edit","Editar");
    dictionary.setProperty("Copy","Copiar");
    dictionary.setProperty("Delete","Borrar");
    dictionary.setProperty("Save","Guardar");
    dictionary.setProperty("Reload","Recargar");
    dictionary.setProperty("Export","Exportar");
    dictionary.setProperty("Filter","Filtrar");

    // MDI Frame...
    dictionary.setProperty("file","Fichero");
    dictionary.setProperty("exit","Salir");
    dictionary.setProperty("filemnemonic","F");
    dictionary.setProperty("exitmnemonic","E");
    dictionary.setProperty("change user","Cambiar Usuario");
    dictionary.setProperty("changeusermnemonic","U");
    dictionary.setProperty("changelanguagemnemonic","L");
    dictionary.setProperty("help","Ayuda");
    dictionary.setProperty("about","Sobre");
    dictionary.setProperty("helpmnemonic","H");
    dictionary.setProperty("aboutmnemonic","A");
    dictionary.setProperty("are you sure to quit application?","�Est�s seguro de que deseas salir de la aplicaci�n?");
    dictionary.setProperty("quit application","Salir de la Aplicaci�n");
    dictionary.setProperty("forcegcmnemonic","F");
    dictionary.setProperty("Force GC","Forzar GC");
    dictionary.setProperty("Java Heap","Java Heap");
    dictionary.setProperty("used","usado");
    dictionary.setProperty("allocated","asignado");
    dictionary.setProperty("change language","Cambiar idioma");
    dictionary.setProperty("changemnemonic","L");
    dictionary.setProperty("cancelmnemonic","C");
    dictionary.setProperty("cancel","Cancelar");
    dictionary.setProperty("yes","S�");
    dictionary.setProperty("no","No");
    dictionary.setProperty("Functions","Funciones");
    dictionary.setProperty("Error while executing function","Error mientras se ejecutaba la funci�n");
    dictionary.setProperty("Error","Error");
    dictionary.setProperty("infoPanel","Info");
    dictionary.setProperty("imageButton","Acerca de GP..");
    dictionary.setProperty("Window","Ventana");
    dictionary.setProperty("windowmnemonic","W");
    dictionary.setProperty("Close All","Cerrar Todo");
    dictionary.setProperty("closeallmnemonic","A");
    dictionary.setProperty("Press ENTER to find function","Pulsa ENTER para buscar la funci�n");
    dictionary.setProperty("Find Function","Buscar Funci�n");
    dictionary.setProperty("Operation in progress...","Operaci�n en progreso...");
    dictionary.setProperty("close window","Cerrar Ventana");
    dictionary.setProperty("reduce to icon","Reducir a icono");
    dictionary.setProperty("save changes?", "Guardar cambios?");
    dictionary.setProperty("confirm window closing","Confirmaci�n para cerrar la ventana");
    dictionary.setProperty("change background","Change background");
    dictionary.setProperty("reset background","Reset background");

    dictionary.setProperty("switch","Cambiar");
    dictionary.setProperty("switchmnemonic","S");
    dictionary.setProperty("window name","Nombre de la ventana");
    dictionary.setProperty("opened windows","Ventanas abiertas");
    dictionary.setProperty("tile horizontally","Colocar horizontalmente");
    dictionary.setProperty("tilehorizontallymnemonic","H");
    dictionary.setProperty("tile vertically","Colocar verticalmente");
    dictionary.setProperty("tileverticallymnemonic","V");
    dictionary.setProperty("cascade","Colocar en cascada");
    dictionary.setProperty("cascademnemonic","C");
    dictionary.setProperty("minimize","Minimizar");
    dictionary.setProperty("minimizemnemonic","M");
    dictionary.setProperty("minimize all","Minimizar todo");
    dictionary.setProperty("minimizeallmnemonic","A");

    // server...
    dictionary.setProperty("Client request not supported","La petici�n del cliente no es soportada");
    dictionary.setProperty("User disconnected","Usuario desconectado");
    dictionary.setProperty("Updating not performed: the record was previously updated.","No se ha hecho la actualizaci�n: el registro habia sido actualizado con anterioridad.");

    // wizard...
    dictionary.setProperty("back","Atr�s");
    dictionary.setProperty("next","Siguiente");
    dictionary.setProperty("finish","Finalizar");

    // image panel...
    dictionary.setProperty("image selection","Selecci�n de imagen");

    // tip of the day panel...
    dictionary.setProperty("show 'tip of the day' after launching","Mostrar 'consejo del d�a' al inicio");
    dictionary.setProperty("previous tip","Consejo anterior");
    dictionary.setProperty("next tip","Consejo siguiente");
    dictionary.setProperty("close","Cerrar");
    dictionary.setProperty("tip of the day","Consejo del d�a");
    dictionary.setProperty("select tip","Seleccion Consejo");
    dictionary.setProperty("tip name","Nombre de el consejo");
    dictionary.setProperty("tips list","Lista de consejos");

    // progress panel...
    dictionary.setProperty("progress","Progreso");

    // licence agreement...
    dictionary.setProperty("i accept the terms in the licence agreement","acepto los t�rminos en el acuerdo de licencia");
    dictionary.setProperty("ok","Ok");
    dictionary.setProperty("i do not accept the terms in the licence agreement","no acepto los t�rminos en el acuerdo de licencia");

    // property grid control
    dictionary.setProperty("property name","Nombre");
    dictionary.setProperty("property value","Valor");

    // grid profile
    dictionary.setProperty("grid profile management","Gesti�n del perfil del grid");
    dictionary.setProperty("restore default grid profile","Restaurar el perfil por defecto del grid");
    dictionary.setProperty("create new grid profile","Crear un nuevo perfil del grid");
    dictionary.setProperty("profile description","Descripci�n del perfil");
    dictionary.setProperty("remove current grid profile","Borrar el perfil del grid actual");
    dictionary.setProperty("select grid profile","Seleccionar el perfil del grid");
    dictionary.setProperty("default profile","Perfil por defecto");

    // search box
    dictionary.setProperty("search","Buscar");
    dictionary.setProperty("not found","No encontrado");

    // drag...
    dictionary.setProperty("drag","Arrastrar");

    // pivot table...
    dictionary.setProperty("pivot table settings","Pivot table settings");
    dictionary.setProperty("row fields","Row fields");
    dictionary.setProperty("column fields","Column fields");
    dictionary.setProperty("data fields","Data fields");
    dictionary.setProperty("filtering conditions","Filtering conditions");
    dictionary.setProperty("field","Field");
    dictionary.setProperty("checked","Checked");
    dictionary.setProperty("at least one data field must be selected","At least one data field must be selected.");
    dictionary.setProperty("at least one row field must be selected","At least one row field must be selected.");
    dictionary.setProperty("at least one column field must be selected","At least one column field must be selected.");
    dictionary.setProperty("expand all","Expand all");
    dictionary.setProperty("collapse all","Collapse all");

    resources = new Resources(
      dictionary,
      currencySymbol,
      '.',
      ',',
      Resources.DMY,
      true,
      '/',
      "HH:mm",
      "ES",
      showResourceNotFoundWarning
    );
  }


  /**
   * @return internationalization settings, according with the current language
   */
  public final Resources getResources() {
    return resources;
  }


  /**
   * Load dictionary, according to the specified language id.
   * @param langId language id identifier
   */
  public final void setLanguage(String langId) throws UnsupportedOperationException {
    if (!resources.getLanguageId().equals(langId))
      throw new UnsupportedOperationException("Identificador de lenguaje no soportado.");
  }


  /**
   * @param langId language id identifier
   * @return internationalization settings, according with the language specified
   */
  public final Resources getResources(String langId) throws UnsupportedOperationException {
    if (!resources.getLanguageId().equals(langId))
    throw new UnsupportedOperationException("Identificador de lenguaje no soportado.");
    return resources;
  }



}

