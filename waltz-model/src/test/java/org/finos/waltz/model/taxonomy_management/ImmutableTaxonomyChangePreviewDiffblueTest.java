package org.finos.waltz.model.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableTaxonomyChangePreviewDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableTaxonomyChangePreview#builder()}
   *   <li>{@link ImmutableTaxonomyChangePreview#errorMessage(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableTaxonomyChangePreview.Builder actualBuilderResult = ImmutableTaxonomyChangePreview.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.errorMessage("An error occurred"));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview.Builder#addAllImpacts(Iterable)}
   */
  @Test
  void testBuilderAddAllImpacts() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllImpacts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview.Builder#addImpacts(TaxonomyChangeImpact)}
   */
  @Test
  void testBuilderAddImpacts() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addImpacts(new ImmutableTaxonomyChangeImpact.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview.Builder#addImpacts(TaxonomyChangeImpact[])}
   */
  @Test
  void testBuilderAddImpacts2() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addImpacts(new ImmutableTaxonomyChangeImpact.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview.Builder#command(TaxonomyChangeCommand)}
   */
  @Test
  void testBuilderCommand() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();
    ImmutableTaxonomyChangeCommand.Json command = new ImmutableTaxonomyChangeCommand.Json();

    // Act
    ImmutableTaxonomyChangePreview.Builder actualCommandResult = builderResult.command(command);

    // Assert
    ImmutableTaxonomyChangePreview buildResult = builderResult.build();
    assertNull(buildResult.errorMessage());
    assertSame(command, buildResult.command());
    assertSame(builderResult, actualCommandResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview.Builder#command(TaxonomyChangeCommand)}
   */
  @Test
  void testBuilderCommand2() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    ImmutableTaxonomyChangeCommand.Json command = new ImmutableTaxonomyChangeCommand.Json();
    command.setChangeDomain(mock(EntityReference.class));

    // Act
    ImmutableTaxonomyChangePreview.Builder actualCommandResult = builderResult.command(command);

    // Assert
    ImmutableTaxonomyChangePreview buildResult = builderResult.build();
    assertNull(buildResult.errorMessage());
    assertSame(command, buildResult.command());
    assertSame(builderResult, actualCommandResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview.Builder#from(TaxonomyChangePreview)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();
    TaxonomyChangePreview instance = mock(TaxonomyChangePreview.class);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.impacts()).thenReturn(new ArrayList<>());
    ImmutableTaxonomyChangeCommand.Json json = new ImmutableTaxonomyChangeCommand.Json();
    when(instance.command()).thenReturn(json);

    // Act
    ImmutableTaxonomyChangePreview.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).command();
    verify(instance).errorMessage();
    verify(instance).impacts();
    ImmutableTaxonomyChangePreview buildResult = builderResult.build();
    assertEquals("An error occurred", buildResult.errorMessage());
    assertSame(json, buildResult.command());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview.Builder#from(TaxonomyChangePreview)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();
    TaxonomyChangePreview instance = mock(TaxonomyChangePreview.class);
    when(instance.impacts()).thenThrow(new IllegalStateException("instance"));
    when(instance.command()).thenReturn(new ImmutableTaxonomyChangeCommand.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).command();
    verify(instance).impacts();
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview.Builder#from(TaxonomyChangePreview)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();
    TaxonomyChangePreview instance = mock(TaxonomyChangePreview.class);
    when(instance.errorMessage()).thenReturn(null);
    when(instance.impacts()).thenReturn(new ArrayList<>());
    ImmutableTaxonomyChangeCommand.Json json = new ImmutableTaxonomyChangeCommand.Json();
    when(instance.command()).thenReturn(json);

    // Act
    ImmutableTaxonomyChangePreview.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).command();
    verify(instance).errorMessage();
    verify(instance).impacts();
    ImmutableTaxonomyChangePreview buildResult = builderResult.build();
    assertNull(buildResult.errorMessage());
    assertSame(json, buildResult.command());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview.Builder#from(TaxonomyChangePreview)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    ArrayList<TaxonomyChangeImpact> taxonomyChangeImpactList = new ArrayList<>();
    ImmutableTaxonomyChangeImpact.Json json = new ImmutableTaxonomyChangeImpact.Json();
    taxonomyChangeImpactList.add(json);
    TaxonomyChangePreview instance = mock(TaxonomyChangePreview.class);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.impacts()).thenReturn(taxonomyChangeImpactList);
    ImmutableTaxonomyChangeCommand.Json json2 = new ImmutableTaxonomyChangeCommand.Json();
    when(instance.command()).thenReturn(json2);

    // Act
    ImmutableTaxonomyChangePreview.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).command();
    verify(instance).errorMessage();
    verify(instance).impacts();
    ImmutableTaxonomyChangePreview buildResult = builderResult.build();
    assertEquals("An error occurred", buildResult.errorMessage());
    List<TaxonomyChangeImpact> impactsResult = buildResult.impacts();
    assertEquals(1, impactsResult.size());
    assertSame(json2, buildResult.command());
    assertSame(json, impactsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview.Builder#impacts(Iterable)}
   */
  @Test
  void testBuilderImpacts() {
    // Arrange
    ImmutableTaxonomyChangePreview.Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.impacts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview#copyOf(TaxonomyChangePreview)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    TaxonomyChangePreview instance = mock(TaxonomyChangePreview.class);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.impacts()).thenReturn(new ArrayList<>());
    ImmutableTaxonomyChangeCommand.Json json = new ImmutableTaxonomyChangeCommand.Json();
    when(instance.command()).thenReturn(json);

    // Act
    ImmutableTaxonomyChangePreview actualCopyOfResult = ImmutableTaxonomyChangePreview.copyOf(instance);

    // Assert
    verify(instance).command();
    verify(instance).errorMessage();
    verify(instance).impacts();
    assertEquals("An error occurred", actualCopyOfResult.errorMessage());
    assertTrue(actualCopyOfResult.impacts().isEmpty());
    assertSame(json, actualCopyOfResult.command());
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview#copyOf(TaxonomyChangePreview)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<TaxonomyChangeImpact> taxonomyChangeImpactList = new ArrayList<>();
    taxonomyChangeImpactList.add(new ImmutableTaxonomyChangeImpact.Json());
    TaxonomyChangePreview instance = mock(TaxonomyChangePreview.class);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.impacts()).thenReturn(taxonomyChangeImpactList);
    ImmutableTaxonomyChangeCommand.Json json = new ImmutableTaxonomyChangeCommand.Json();
    when(instance.command()).thenReturn(json);

    // Act
    ImmutableTaxonomyChangePreview actualCopyOfResult = ImmutableTaxonomyChangePreview.copyOf(instance);

    // Assert
    verify(instance).command();
    verify(instance).errorMessage();
    verify(instance).impacts();
    assertEquals("An error occurred", actualCopyOfResult.errorMessage());
    assertEquals(taxonomyChangeImpactList, actualCopyOfResult.impacts());
    assertSame(json, actualCopyOfResult.command());
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview#copyOf(TaxonomyChangePreview)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<TaxonomyChangeImpact> taxonomyChangeImpactList = new ArrayList<>();
    taxonomyChangeImpactList.add(new ImmutableTaxonomyChangeImpact.Json());
    taxonomyChangeImpactList.add(new ImmutableTaxonomyChangeImpact.Json());
    TaxonomyChangePreview instance = mock(TaxonomyChangePreview.class);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.impacts()).thenReturn(taxonomyChangeImpactList);
    ImmutableTaxonomyChangeCommand.Json json = new ImmutableTaxonomyChangeCommand.Json();
    when(instance.command()).thenReturn(json);

    // Act
    ImmutableTaxonomyChangePreview actualCopyOfResult = ImmutableTaxonomyChangePreview.copyOf(instance);

    // Assert
    verify(instance).command();
    verify(instance).errorMessage();
    verify(instance).impacts();
    assertEquals("An error occurred", actualCopyOfResult.errorMessage());
    assertEquals(taxonomyChangeImpactList, actualCopyOfResult.impacts());
    assertSame(json, actualCopyOfResult.command());
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview#fromJson(ImmutableTaxonomyChangePreview.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableTaxonomyChangePreview.Json json = new ImmutableTaxonomyChangePreview.Json();
    ImmutableTaxonomyChangeCommand.Json command = new ImmutableTaxonomyChangeCommand.Json();
    json.setCommand(command);
    json.setImpacts(null);
    json.setErrorMessage(null);

    // Act
    ImmutableTaxonomyChangePreview actualFromJsonResult = ImmutableTaxonomyChangePreview.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.errorMessage());
    assertTrue(actualFromJsonResult.impacts().isEmpty());
    assertSame(command, actualFromJsonResult.command());
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview#fromJson(ImmutableTaxonomyChangePreview.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<TaxonomyChangeImpact> impacts = new ArrayList<>();
    impacts.add(new ImmutableTaxonomyChangeImpact.Json());

    ImmutableTaxonomyChangePreview.Json json = new ImmutableTaxonomyChangePreview.Json();
    ImmutableTaxonomyChangeCommand.Json command = new ImmutableTaxonomyChangeCommand.Json();
    json.setCommand(command);
    json.setImpacts(impacts);
    json.setErrorMessage(null);

    // Act
    ImmutableTaxonomyChangePreview actualFromJsonResult = ImmutableTaxonomyChangePreview.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.errorMessage());
    assertEquals(impacts, actualFromJsonResult.impacts());
    assertSame(command, actualFromJsonResult.command());
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangePreview#fromJson(ImmutableTaxonomyChangePreview.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<TaxonomyChangeImpact> impacts = new ArrayList<>();
    impacts.add(new ImmutableTaxonomyChangeImpact.Json());
    impacts.add(new ImmutableTaxonomyChangeImpact.Json());

    ImmutableTaxonomyChangePreview.Json json = new ImmutableTaxonomyChangePreview.Json();
    ImmutableTaxonomyChangeCommand.Json command = new ImmutableTaxonomyChangeCommand.Json();
    json.setCommand(command);
    json.setImpacts(impacts);
    json.setErrorMessage(null);

    // Act
    ImmutableTaxonomyChangePreview actualFromJsonResult = ImmutableTaxonomyChangePreview.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.errorMessage());
    assertEquals(impacts, actualFromJsonResult.impacts());
    assertSame(command, actualFromJsonResult.command());
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangePreview.Json#command()}
   */
  @Test
  void testJsonCommand() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTaxonomyChangePreview.Json()).command());
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangePreview.Json#errorMessage()}
   */
  @Test
  void testJsonErrorMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTaxonomyChangePreview.Json()).errorMessage());
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangePreview.Json#impacts()}
   */
  @Test
  void testJsonImpacts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTaxonomyChangePreview.Json()).impacts());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableTaxonomyChangePreview.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableTaxonomyChangePreview.Json actualJson = new ImmutableTaxonomyChangePreview.Json();

    // Assert
    assertNull(actualJson.errorMessage);
    assertNull(actualJson.command);
    assertTrue(actualJson.impacts.isEmpty());
  }
}
