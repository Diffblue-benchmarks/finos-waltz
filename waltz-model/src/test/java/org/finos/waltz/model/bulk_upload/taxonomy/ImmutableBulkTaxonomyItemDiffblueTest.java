package org.finos.waltz.model.bulk_upload.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyItem.Builder;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyItemDiffblueTest {
  /**
   * Test {@link ImmutableBulkTaxonomyItem#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyItem#builder()}
   *   <li>{@link ImmutableBulkTaxonomyItem#description(String)}
   *   <li>{@link ImmutableBulkTaxonomyItem#parentExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkTaxonomyItem Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.parentExternalId(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualDescriptionResult = ImmutableBulkTaxonomyItem.builder()
        .description("The characteristics of someone or something");

    // Assert
    assertSame(actualDescriptionResult, actualDescriptionResult.parentExternalId("42"));
  }

  /**
   * Test Builder {@link Builder#concrete(boolean)}.
   * <p>
   * Method under test: {@link Builder#concrete(boolean)}
   */
  @Test
  @DisplayName("Test Builder concrete(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.concrete(boolean)"})
  void testBuilderConcrete() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.concrete(true));
  }

  /**
   * Test Builder {@link Builder#externalId(String)}.
   * <p>
   * Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyItem)}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyItem); then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyItem)"})
  void testBuilderFrom_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyItem.builder();
    BulkTaxonomyItem instance = mock(BulkTaxonomyItem.class);
    when(instance.description()).thenReturn(null);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.concrete()).thenReturn(true);
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).concrete();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).parentExternalId();
    ImmutableBulkTaxonomyItem buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.parentExternalId());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertTrue(buildResult.concrete());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyItem)}.
   * <ul>
   *   <li>Then builder build parentExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyItem); then builder build parentExternalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyItem)"})
  void testBuilderFrom_thenBuilderBuildParentExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyItem.builder();
    BulkTaxonomyItem instance = mock(BulkTaxonomyItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.concrete()).thenReturn(true);
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).concrete();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).parentExternalId();
    ImmutableBulkTaxonomyItem buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.parentExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertTrue(buildResult.concrete());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyItem)}.
   * <ul>
   *   <li>Then builder build parentExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyItem); then builder build parentExternalId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyItem)"})
  void testBuilderFrom_thenBuilderBuildParentExternalIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyItem.builder();
    BulkTaxonomyItem instance = mock(BulkTaxonomyItem.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.parentExternalId()).thenReturn(null);
    when(instance.concrete()).thenReturn(true);
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).concrete();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).parentExternalId();
    ImmutableBulkTaxonomyItem buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.parentExternalId());
    assertTrue(buildResult.concrete());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyItem)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyItem); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyItem)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyItem.builder();
    BulkTaxonomyItem instance = mock(BulkTaxonomyItem.class);
    when(instance.parentExternalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.externalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).parentExternalId();
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Json {@link Json#concrete()}.
   * <p>
   * Method under test: {@link Json#concrete()}
   */
  @Test
  @DisplayName("Test Json concrete()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.concrete()"})
  void testJsonConcrete() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).concrete());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setExternalId(String)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setParentExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDescription(String)", "void Json.setExternalId(String)",
      "void Json.setName(String)", "void Json.setParentExternalId(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setExternalId("42");
    actualJson.setName("Name");
    actualJson.setParentExternalId("42");

    // Assert
    assertEquals("42", actualJson.externalId);
    assertEquals("42", actualJson.parentExternalId);
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertFalse(actualJson.concrete);
    assertFalse(actualJson.concreteIsSet);
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json {@link Json#parentExternalId()}.
   * <p>
   * Method under test: {@link Json#parentExternalId()}
   */
  @Test
  @DisplayName("Test Json parentExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.parentExternalId()"})
  void testJsonParentExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentExternalId());
  }

  /**
   * Test Json {@link Json#setConcrete(boolean)}.
   * <p>
   * Method under test: {@link Json#setConcrete(boolean)}
   */
  @Test
  @DisplayName("Test Json setConcrete(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setConcrete(boolean)"})
  void testJsonSetConcrete() {
    // Arrange
    Json json = new Json();

    // Act
    json.setConcrete(true);

    // Assert
    assertTrue(json.concrete);
    assertTrue(json.concreteIsSet);
  }
}
