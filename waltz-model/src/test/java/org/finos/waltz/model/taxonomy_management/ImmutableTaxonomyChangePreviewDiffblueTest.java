package org.finos.waltz.model.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangePreview.Builder;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangePreview.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTaxonomyChangePreviewDiffblueTest {
  /**
   * Test {@link ImmutableTaxonomyChangePreview#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableTaxonomyChangePreview#builder()}
   *   <li>{@link ImmutableTaxonomyChangePreview#errorMessage(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableTaxonomyChangePreview Builder.build()", "Builder Builder.errorMessage(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableTaxonomyChangePreview.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.errorMessage("An error occurred"));
  }

  /**
   * Test Builder {@link Builder#addAllImpacts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllImpacts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllImpacts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllImpacts(Iterable)"})
  void testBuilderAddAllImpacts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllImpacts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addImpacts(TaxonomyChangeImpact)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableTaxonomyChangeImpact.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addImpacts(TaxonomyChangeImpact)}
   */
  @Test
  @DisplayName("Test Builder addImpacts(TaxonomyChangeImpact) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addImpacts(TaxonomyChangeImpact)"})
  void testBuilderAddImpactsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addImpacts(new ImmutableTaxonomyChangeImpact.Json()));
  }

  /**
   * Test Builder {@link Builder#addImpacts(TaxonomyChangeImpact[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableTaxonomyChangeImpact.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addImpacts(TaxonomyChangeImpact[])}
   */
  @Test
  @DisplayName("Test Builder addImpacts(TaxonomyChangeImpact[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addImpacts(TaxonomyChangeImpact[])"})
  void testBuilderAddImpactsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addImpacts(new ImmutableTaxonomyChangeImpact.Json()));
  }

  /**
   * Test Builder {@link Builder#command(TaxonomyChangeCommand)}.
   * <ul>
   *   <li>When {@link ImmutableTaxonomyChangeCommand.Json} (default constructor).</li>
   *   <li>Then builder build errorMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#command(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder command(TaxonomyChangeCommand); when Json (default constructor); then builder build errorMessage is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.command(TaxonomyChangeCommand)"})
  void testBuilderCommand_whenJson_thenBuilderBuildErrorMessageIsNull() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangePreview.builder();
    ImmutableTaxonomyChangeCommand.Json command = new ImmutableTaxonomyChangeCommand.Json();

    // Act
    Builder actualCommandResult = builderResult.command(command);

    // Assert
    ImmutableTaxonomyChangePreview buildResult = builderResult.build();
    assertNull(buildResult.errorMessage());
    assertSame(command, buildResult.command());
    assertSame(builderResult, actualCommandResult);
  }

  /**
   * Test Builder {@link Builder#from(TaxonomyChangePreview)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableTaxonomyChangeImpact.Json} (default constructor).</li>
   *   <li>Then builder build impacts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TaxonomyChangePreview)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangePreview); given ArrayList() add Json (default constructor); then builder build impacts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangePreview)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuilderBuildImpactsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    ArrayList<TaxonomyChangeImpact> taxonomyChangeImpactList = new ArrayList<>();
    ImmutableTaxonomyChangeImpact.Json json = new ImmutableTaxonomyChangeImpact.Json();
    taxonomyChangeImpactList.add(json);
    TaxonomyChangePreview instance = mock(TaxonomyChangePreview.class);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.impacts()).thenReturn(taxonomyChangeImpactList);
    when(instance.command()).thenReturn(new ImmutableTaxonomyChangeCommand.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).command();
    verify(instance).errorMessage();
    verify(instance).impacts();
    List<TaxonomyChangeImpact> impactsResult = builderResult.build().impacts();
    assertEquals(1, impactsResult.size());
    assertEquals(taxonomyChangeImpactList, actualFromResult.build().impacts());
    assertSame(json, impactsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(TaxonomyChangePreview)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build errorMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TaxonomyChangePreview)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangePreview); given ArrayList(); then builder build errorMessage is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangePreview)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildErrorMessageIsAnErrorOccurred() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangePreview.builder();
    TaxonomyChangePreview instance = mock(TaxonomyChangePreview.class);
    when(instance.errorMessage()).thenReturn("An error occurred");
    when(instance.impacts()).thenReturn(new ArrayList<>());
    ImmutableTaxonomyChangeCommand.Json json = new ImmutableTaxonomyChangeCommand.Json();
    when(instance.command()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(TaxonomyChangePreview)}.
   * <ul>
   *   <li>Then builder build errorMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TaxonomyChangePreview)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangePreview); then builder build errorMessage is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangePreview)"})
  void testBuilderFrom_thenBuilderBuildErrorMessageIsNull() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangePreview.builder();
    TaxonomyChangePreview instance = mock(TaxonomyChangePreview.class);
    when(instance.errorMessage()).thenReturn(null);
    when(instance.impacts()).thenReturn(new ArrayList<>());
    ImmutableTaxonomyChangeCommand.Json json = new ImmutableTaxonomyChangeCommand.Json();
    when(instance.command()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(TaxonomyChangePreview)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TaxonomyChangePreview)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangePreview); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangePreview)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangePreview.builder();
    TaxonomyChangePreview instance = mock(TaxonomyChangePreview.class);
    when(instance.impacts()).thenThrow(new IllegalStateException("instance"));
    when(instance.command()).thenReturn(new ImmutableTaxonomyChangeCommand.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).command();
    verify(instance).impacts();
  }

  /**
   * Test Builder {@link Builder#impacts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#impacts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder impacts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.impacts(Iterable)"})
  void testBuilderImpacts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangePreview.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.impacts(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#command()}.
   * <p>
   * Method under test: {@link Json#command()}
   */
  @Test
  @DisplayName("Test Json command()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TaxonomyChangeCommand Json.command()"})
  void testJsonCommand() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).command());
  }

  /**
   * Test Json {@link Json#errorMessage()}.
   * <p>
   * Method under test: {@link Json#errorMessage()}
   */
  @Test
  @DisplayName("Test Json errorMessage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.errorMessage()"})
  void testJsonErrorMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).errorMessage());
  }

  /**
   * Test Json {@link Json#impacts()}.
   * <p>
   * Method under test: {@link Json#impacts()}
   */
  @Test
  @DisplayName("Test Json impacts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.impacts()"})
  void testJsonImpacts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).impacts());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.errorMessage);
    assertNull(actualJson.command);
    assertTrue(actualJson.impacts.isEmpty());
  }
}
