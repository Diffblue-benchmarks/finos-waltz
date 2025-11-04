package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.entity_field_reference.EntityFieldReference;
import org.junit.jupiter.api.Test;

class ImmutableReportGridColumnDefinitionsUpdateCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#addAllDerivedColumnDefinitions(Iterable)}
   */
  @Test
  void testBuilderAddAllDerivedColumnDefinitions() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDerivedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#addAllDerivedColumnDefinitions(Iterable)}
   */
  @Test
  void testBuilderAddAllDerivedColumnDefinitions2() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Json element = new ImmutableReportGridFixedColumnDefinition.Json();
    element.setEntityFieldReference(mock(EntityFieldReference.class));
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();
    builderResult.addFixedColumnDefinitions(element);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDerivedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#addAllFixedColumnDefinitions(Iterable)}
   */
  @Test
  void testBuilderAddAllFixedColumnDefinitions() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFixedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testBuilderAddDerivedColumnDefinitions() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();
    ImmutableReportGridDerivedColumnDefinition.Json element = new ImmutableReportGridDerivedColumnDefinition.Json();

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder actualAddDerivedColumnDefinitionsResult = builderResult
        .addDerivedColumnDefinitions(element);

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = builderResult.build()
        .derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    assertSame(element, derivedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddDerivedColumnDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testBuilderAddDerivedColumnDefinitions2() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Json element = new ImmutableReportGridFixedColumnDefinition.Json();
    element.setEntityFieldReference(mock(EntityFieldReference.class));
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();
    builderResult.addFixedColumnDefinitions(element);
    ImmutableReportGridDerivedColumnDefinition.Json element2 = new ImmutableReportGridDerivedColumnDefinition.Json();

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder actualAddDerivedColumnDefinitionsResult = builderResult
        .addDerivedColumnDefinitions(element2);

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = builderResult.build()
        .derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    assertSame(element2, derivedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddDerivedColumnDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])}
   */
  @Test
  void testBuilderAddDerivedColumnDefinitions3() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();
    ImmutableReportGridDerivedColumnDefinition.Json json = new ImmutableReportGridDerivedColumnDefinition.Json();

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder actualAddDerivedColumnDefinitionsResult = builderResult
        .addDerivedColumnDefinitions(json);

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = builderResult.build()
        .derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    assertSame(json, derivedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddDerivedColumnDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderAddFixedColumnDefinitions() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();
    ImmutableReportGridFixedColumnDefinition.Json element = new ImmutableReportGridFixedColumnDefinition.Json();

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder actualAddFixedColumnDefinitionsResult = builderResult
        .addFixedColumnDefinitions(element);

    // Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult = builderResult.build().fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertSame(element, fixedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddFixedColumnDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderAddFixedColumnDefinitions2() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();

    ImmutableReportGridFixedColumnDefinition.Json element = new ImmutableReportGridFixedColumnDefinition.Json();
    element.setEntityFieldReference(mock(EntityFieldReference.class));

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder actualAddFixedColumnDefinitionsResult = builderResult
        .addFixedColumnDefinitions(element);

    // Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult = builderResult.build().fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertSame(element, fixedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddFixedColumnDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])}
   */
  @Test
  void testBuilderAddFixedColumnDefinitions3() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();
    ImmutableReportGridFixedColumnDefinition.Json json = new ImmutableReportGridFixedColumnDefinition.Json();

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder actualAddFixedColumnDefinitionsResult = builderResult
        .addFixedColumnDefinitions(json);

    // Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult = builderResult.build().fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertSame(json, fixedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddFixedColumnDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])}
   */
  @Test
  void testBuilderAddFixedColumnDefinitions4() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();

    ImmutableReportGridFixedColumnDefinition.Json json = new ImmutableReportGridFixedColumnDefinition.Json();
    json.setEntityFieldReference(mock(EntityFieldReference.class));

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder actualAddFixedColumnDefinitionsResult = builderResult
        .addFixedColumnDefinitions(json);

    // Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult = builderResult.build().fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertSame(json, fixedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualAddFixedColumnDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableReportGridColumnDefinitionsUpdateCommand.builder().build().derivedColumnDefinitions().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#derivedColumnDefinitions(Iterable)}
   */
  @Test
  void testBuilderDerivedColumnDefinitions() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.derivedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#derivedColumnDefinitions(Iterable)}
   */
  @Test
  void testBuilderDerivedColumnDefinitions2() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Json element = new ImmutableReportGridFixedColumnDefinition.Json();
    element.setEntityFieldReference(mock(EntityFieldReference.class));
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();
    builderResult.addFixedColumnDefinitions(element);

    // Act and Assert
    assertSame(builderResult, builderResult.derivedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#fixedColumnDefinitions(Iterable)}
   */
  @Test
  void testBuilderFixedColumnDefinitions() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fixedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#from(ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();
    ReportGridColumnDefinitionsUpdateCommand instance = mock(ReportGridColumnDefinitionsUpdateCommand.class);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).derivedColumnDefinitions();
    verify(instance).fixedColumnDefinitions();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#from(ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();

    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    ImmutableReportGridDerivedColumnDefinition.Json json = new ImmutableReportGridDerivedColumnDefinition.Json();
    reportGridDerivedColumnDefinitionList.add(json);
    ReportGridColumnDefinitionsUpdateCommand instance = mock(ReportGridColumnDefinitionsUpdateCommand.class);
    when(instance.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).derivedColumnDefinitions();
    verify(instance).fixedColumnDefinitions();
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = builderResult.build()
        .derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    assertSame(json, derivedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Builder#from(ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder builderResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .builder();

    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList = new ArrayList<>();
    ImmutableReportGridFixedColumnDefinition.Json json = new ImmutableReportGridFixedColumnDefinition.Json();
    reportGridFixedColumnDefinitionList.add(json);
    ReportGridColumnDefinitionsUpdateCommand instance = mock(ReportGridColumnDefinitionsUpdateCommand.class);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.fixedColumnDefinitions()).thenReturn(reportGridFixedColumnDefinitionList);

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).derivedColumnDefinitions();
    verify(instance).fixedColumnDefinitions();
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult = builderResult.build().fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertSame(json, fixedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand#copyOf(ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridColumnDefinitionsUpdateCommand instance = mock(ReportGridColumnDefinitionsUpdateCommand.class);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualCopyOfResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .copyOf(instance);

    // Assert
    verify(instance).derivedColumnDefinitions();
    verify(instance).fixedColumnDefinitions();
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = actualCopyOfResult
        .derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualCopyOfResult.fixedColumnDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand#copyOf(ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    reportGridDerivedColumnDefinitionList.add(new ImmutableReportGridDerivedColumnDefinition.Json());
    ReportGridColumnDefinitionsUpdateCommand instance = mock(ReportGridColumnDefinitionsUpdateCommand.class);
    when(instance.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualCopyOfResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .copyOf(instance);

    // Assert
    verify(instance).derivedColumnDefinitions();
    verify(instance).fixedColumnDefinitions();
    assertTrue(actualCopyOfResult.fixedColumnDefinitions().isEmpty());
    assertEquals(reportGridDerivedColumnDefinitionList, actualCopyOfResult.derivedColumnDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand#copyOf(ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    reportGridDerivedColumnDefinitionList.add(new ImmutableReportGridDerivedColumnDefinition.Json());
    reportGridDerivedColumnDefinitionList.add(new ImmutableReportGridDerivedColumnDefinition.Json());
    ReportGridColumnDefinitionsUpdateCommand instance = mock(ReportGridColumnDefinitionsUpdateCommand.class);
    when(instance.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualCopyOfResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .copyOf(instance);

    // Assert
    verify(instance).derivedColumnDefinitions();
    verify(instance).fixedColumnDefinitions();
    assertTrue(actualCopyOfResult.fixedColumnDefinitions().isEmpty());
    assertEquals(reportGridDerivedColumnDefinitionList, actualCopyOfResult.derivedColumnDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand#copyOf(ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList = new ArrayList<>();
    reportGridFixedColumnDefinitionList.add(new ImmutableReportGridFixedColumnDefinition.Json());
    ReportGridColumnDefinitionsUpdateCommand instance = mock(ReportGridColumnDefinitionsUpdateCommand.class);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.fixedColumnDefinitions()).thenReturn(reportGridFixedColumnDefinitionList);

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualCopyOfResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .copyOf(instance);

    // Assert
    verify(instance).derivedColumnDefinitions();
    verify(instance).fixedColumnDefinitions();
    assertTrue(actualCopyOfResult.derivedColumnDefinitions().isEmpty());
    assertEquals(reportGridFixedColumnDefinitionList, actualCopyOfResult.fixedColumnDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(ImmutableReportGridColumnDefinitionsUpdateCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Json json = new ImmutableReportGridColumnDefinitionsUpdateCommand.Json();

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .fromJson(json);

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = actualFromJsonResult
        .derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    List<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList = json.fixedColumnDefinitions;
    assertSame(reportGridFixedColumnDefinitionList, derivedColumnDefinitionsResult);
    assertSame(reportGridFixedColumnDefinitionList, actualFromJsonResult.fixedColumnDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(ImmutableReportGridColumnDefinitionsUpdateCommand.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableReportGridColumnDefinitionsUpdateCommand.Json json = new ImmutableReportGridColumnDefinitionsUpdateCommand.Json();
    json.setFixedColumnDefinitions(null);
    json.setDerivedColumnDefinitions(null);

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .fromJson(json);

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = actualFromJsonResult
        .derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualFromJsonResult.fixedColumnDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(ImmutableReportGridColumnDefinitionsUpdateCommand.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = new ArrayList<>();
    derivedColumnDefinitions.add(new ImmutableReportGridDerivedColumnDefinition.Json());

    ImmutableReportGridColumnDefinitionsUpdateCommand.Json json = new ImmutableReportGridColumnDefinitionsUpdateCommand.Json();
    json.setFixedColumnDefinitions(null);
    json.setDerivedColumnDefinitions(derivedColumnDefinitions);

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.fixedColumnDefinitions().isEmpty());
    assertEquals(derivedColumnDefinitions, actualFromJsonResult.derivedColumnDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(ImmutableReportGridColumnDefinitionsUpdateCommand.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ArrayList<ReportGridFixedColumnDefinition> fixedColumnDefinitions = new ArrayList<>();
    fixedColumnDefinitions.add(new ImmutableReportGridFixedColumnDefinition.Json());

    ImmutableReportGridColumnDefinitionsUpdateCommand.Json json = new ImmutableReportGridColumnDefinitionsUpdateCommand.Json();
    json.setFixedColumnDefinitions(fixedColumnDefinitions);
    json.setDerivedColumnDefinitions(null);

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.derivedColumnDefinitions().isEmpty());
    assertEquals(fixedColumnDefinitions, actualFromJsonResult.fixedColumnDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(ImmutableReportGridColumnDefinitionsUpdateCommand.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    COWArrayList<ReportGridFixedColumnDefinition> fixedColumnDefinitions = mock(COWArrayList.class);

    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList = new ArrayList<>();
    when(fixedColumnDefinitions.iterator()).thenReturn(reportGridFixedColumnDefinitionList.iterator());

    ImmutableReportGridColumnDefinitionsUpdateCommand.Json json = new ImmutableReportGridColumnDefinitionsUpdateCommand.Json();
    json.setFixedColumnDefinitions(fixedColumnDefinitions);
    json.setDerivedColumnDefinitions(null);

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .fromJson(json);

    // Assert
    verify(fixedColumnDefinitions).iterator();
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = actualFromJsonResult
        .derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualFromJsonResult.fixedColumnDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand#fromJson(ImmutableReportGridColumnDefinitionsUpdateCommand.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList = new ArrayList<>();
    reportGridFixedColumnDefinitionList.add(new ImmutableReportGridFixedColumnDefinition.Json());
    reportGridFixedColumnDefinitionList.add(new ImmutableReportGridFixedColumnDefinition.Json());
    COWArrayList<ReportGridFixedColumnDefinition> fixedColumnDefinitions = mock(COWArrayList.class);
    when(fixedColumnDefinitions.iterator()).thenReturn(reportGridFixedColumnDefinitionList.iterator());
    COWArrayList<ReportGridDerivedColumnDefinition> derivedColumnDefinitions = mock(COWArrayList.class);

    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    when(derivedColumnDefinitions.iterator()).thenReturn(reportGridDerivedColumnDefinitionList.iterator());

    ImmutableReportGridColumnDefinitionsUpdateCommand.Json json = new ImmutableReportGridColumnDefinitionsUpdateCommand.Json();
    json.setFixedColumnDefinitions(fixedColumnDefinitions);
    json.setDerivedColumnDefinitions(derivedColumnDefinitions);

    // Act
    ImmutableReportGridColumnDefinitionsUpdateCommand actualFromJsonResult = ImmutableReportGridColumnDefinitionsUpdateCommand
        .fromJson(json);

    // Assert
    verify(fixedColumnDefinitions).iterator();
    verify(derivedColumnDefinitions).iterator();
    assertTrue(actualFromJsonResult.derivedColumnDefinitions().isEmpty());
    assertEquals(reportGridFixedColumnDefinitionList, actualFromJsonResult.fixedColumnDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Json#derivedColumnDefinitions()}
   */
  @Test
  void testJsonDerivedColumnDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridColumnDefinitionsUpdateCommand.Json()).derivedColumnDefinitions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Json#fixedColumnDefinitions()}
   */
  @Test
  void testJsonFixedColumnDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridColumnDefinitionsUpdateCommand.Json()).fixedColumnDefinitions());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableReportGridColumnDefinitionsUpdateCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableReportGridColumnDefinitionsUpdateCommand.Json actualJson = new ImmutableReportGridColumnDefinitionsUpdateCommand.Json();

    // Assert
    assertTrue(actualJson.derivedColumnDefinitions.isEmpty());
    assertTrue(actualJson.fixedColumnDefinitions.isEmpty());
  }
}
