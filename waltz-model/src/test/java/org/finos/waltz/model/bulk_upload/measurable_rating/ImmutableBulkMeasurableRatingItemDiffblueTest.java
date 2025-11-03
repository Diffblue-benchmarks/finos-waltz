package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingItem.Builder;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingItemDiffblueTest {
  /**
   * Test {@link ImmutableBulkMeasurableRatingItem#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingItem#builder()}
   *   <li>{@link ImmutableBulkMeasurableRatingItem#allocation(Integer)}
   *   <li>{@link ImmutableBulkMeasurableRatingItem#comment(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allocation(Integer)", "ImmutableBulkMeasurableRatingItem Builder.build()",
      "Builder Builder.comment(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualAllocationResult = ImmutableBulkMeasurableRatingItem.builder().allocation(1);

    // Assert
    assertSame(actualAllocationResult, actualAllocationResult.comment("Comment"));
  }

  /**
   * Test Builder {@link Builder#assetCode(String)}.
   * <p>
   * Method under test: {@link Builder#assetCode(String)}
   */
  @Test
  @DisplayName("Test Builder assetCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assetCode(String)"})
  void testBuilderAssetCode() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assetCode("Asset Code"));
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingItem)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build comment is {@code Comment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingItem); given one; then builder build comment is 'Comment'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingItem)"})
  void testBuilderFrom_givenOne_thenBuilderBuildCommentIsComment() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();
    BulkMeasurableRatingItem instance = mock(BulkMeasurableRatingItem.class);
    when(instance.ratingCode()).thenReturn('A');
    when(instance.allocation()).thenReturn(1);
    when(instance.comment()).thenReturn("Comment");
    when(instance.scheme()).thenReturn("Scheme");
    when(instance.isPrimary()).thenReturn(true);
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.assetCode()).thenReturn("Asset Code");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocation();
    verify(instance).assetCode();
    verify(instance).comment();
    verify(instance).isPrimary();
    verify(instance).ratingCode();
    verify(instance).scheme();
    verify(instance).taxonomyExternalId();
    ImmutableBulkMeasurableRatingItem buildResult = builderResult.build();
    assertEquals("42", buildResult.taxonomyExternalId());
    assertEquals("Asset Code", buildResult.assetCode());
    assertEquals("Comment", buildResult.comment());
    assertEquals("Scheme", buildResult.scheme());
    assertEquals('A', buildResult.ratingCode());
    assertEquals(1, buildResult.allocation().intValue());
    assertTrue(buildResult.isPrimary());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingItem)}.
   * <ul>
   *   <li>Then builder build allocation is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingItem); then builder build allocation is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingItem)"})
  void testBuilderFrom_thenBuilderBuildAllocationIsNull() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();
    BulkMeasurableRatingItem instance = mock(BulkMeasurableRatingItem.class);
    when(instance.ratingCode()).thenReturn('A');
    when(instance.allocation()).thenReturn(null);
    when(instance.comment()).thenReturn("Comment");
    when(instance.scheme()).thenReturn("Scheme");
    when(instance.isPrimary()).thenReturn(true);
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.assetCode()).thenReturn("Asset Code");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocation();
    verify(instance).assetCode();
    verify(instance).comment();
    verify(instance).isPrimary();
    verify(instance).ratingCode();
    verify(instance).scheme();
    verify(instance).taxonomyExternalId();
    ImmutableBulkMeasurableRatingItem buildResult = builderResult.build();
    assertEquals("42", buildResult.taxonomyExternalId());
    assertEquals("Asset Code", buildResult.assetCode());
    assertEquals("Comment", buildResult.comment());
    assertEquals("Scheme", buildResult.scheme());
    assertEquals('A', buildResult.ratingCode());
    assertNull(buildResult.allocation());
    assertTrue(buildResult.isPrimary());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingItem)}.
   * <ul>
   *   <li>Then builder build comment is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingItem); then builder build comment is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingItem)"})
  void testBuilderFrom_thenBuilderBuildCommentIsNull() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();
    BulkMeasurableRatingItem instance = mock(BulkMeasurableRatingItem.class);
    when(instance.ratingCode()).thenReturn('A');
    when(instance.allocation()).thenReturn(1);
    when(instance.comment()).thenReturn(null);
    when(instance.scheme()).thenReturn("Scheme");
    when(instance.isPrimary()).thenReturn(true);
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.assetCode()).thenReturn("Asset Code");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocation();
    verify(instance).assetCode();
    verify(instance).comment();
    verify(instance).isPrimary();
    verify(instance).ratingCode();
    verify(instance).scheme();
    verify(instance).taxonomyExternalId();
    ImmutableBulkMeasurableRatingItem buildResult = builderResult.build();
    assertEquals("42", buildResult.taxonomyExternalId());
    assertEquals("Asset Code", buildResult.assetCode());
    assertEquals("Scheme", buildResult.scheme());
    assertEquals('A', buildResult.ratingCode());
    assertNull(buildResult.comment());
    assertEquals(1, buildResult.allocation().intValue());
    assertTrue(buildResult.isPrimary());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingItem)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingItem); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingItem)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();
    BulkMeasurableRatingItem instance = mock(BulkMeasurableRatingItem.class);
    when(instance.ratingCode()).thenThrow(new IllegalStateException("instance"));
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.assetCode()).thenReturn("Asset Code");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assetCode();
    verify(instance).ratingCode();
    verify(instance).taxonomyExternalId();
  }

  /**
   * Test Builder {@link Builder#isPrimary(boolean)}.
   * <p>
   * Method under test: {@link Builder#isPrimary(boolean)}
   */
  @Test
  @DisplayName("Test Builder isPrimary(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isPrimary(boolean)"})
  void testBuilderIsPrimary() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isPrimary(true));
  }

  /**
   * Test Builder {@link Builder#ratingCode(char)}.
   * <p>
   * Method under test: {@link Builder#ratingCode(char)}
   */
  @Test
  @DisplayName("Test Builder ratingCode(char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingCode(char)"})
  void testBuilderRatingCode() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingCode('A'));
  }

  /**
   * Test Builder {@link Builder#scheme(String)}.
   * <p>
   * Method under test: {@link Builder#scheme(String)}
   */
  @Test
  @DisplayName("Test Builder scheme(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.scheme(String)"})
  void testBuilderScheme() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scheme("Scheme"));
  }

  /**
   * Test Builder {@link Builder#taxonomyExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#taxonomyExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder taxonomyExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.taxonomyExternalId(String)"})
  void testBuilderTaxonomyExternalId() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.taxonomyExternalId("42"));
  }

  /**
   * Test Json {@link Json#allocation()}.
   * <p>
   * Method under test: {@link Json#allocation()}
   */
  @Test
  @DisplayName("Test Json allocation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer Json.allocation()"})
  void testJsonAllocation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allocation());
  }

  /**
   * Test Json {@link Json#assetCode()}.
   * <p>
   * Method under test: {@link Json#assetCode()}
   */
  @Test
  @DisplayName("Test Json assetCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.assetCode()"})
  void testJsonAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assetCode());
  }

  /**
   * Test Json {@link Json#comment()}.
   * <p>
   * Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).comment());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAllocation(Integer)}
   *   <li>{@link Json#setAssetCode(String)}
   *   <li>{@link Json#setComment(String)}
   *   <li>{@link Json#setScheme(String)}
   *   <li>{@link Json#setTaxonomyExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAllocation(Integer)", "void Json.setAssetCode(String)",
      "void Json.setComment(String)", "void Json.setScheme(String)", "void Json.setTaxonomyExternalId(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAllocation(1);
    actualJson.setAssetCode("Asset Code");
    actualJson.setComment("Comment");
    actualJson.setScheme("Scheme");
    actualJson.setTaxonomyExternalId("42");

    // Assert
    assertEquals(1, actualJson.allocation.intValue());
  }

  /**
   * Test Json {@link Json#isPrimary()}.
   * <p>
   * Method under test: {@link Json#isPrimary()}
   */
  @Test
  @DisplayName("Test Json isPrimary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isPrimary()"})
  void testJsonIsPrimary() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isPrimary());
  }

  /**
   * Test Json {@link Json#ratingCode()}.
   * <p>
   * Method under test: {@link Json#ratingCode()}
   */
  @Test
  @DisplayName("Test Json ratingCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char Json.ratingCode()"})
  void testJsonRatingCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingCode());
  }

  /**
   * Test Json {@link Json#scheme()}.
   * <p>
   * Method under test: {@link Json#scheme()}
   */
  @Test
  @DisplayName("Test Json scheme()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.scheme()"})
  void testJsonScheme() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).scheme());
  }

  /**
   * Test Json {@link Json#setIsPrimary(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsPrimary(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsPrimary(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsPrimary(boolean)"})
  void testJsonSetIsPrimary() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsPrimary(true);

    // Assert
    assertTrue(json.isPrimary);
    assertTrue(json.isPrimaryIsSet);
  }

  /**
   * Test Json {@link Json#setRatingCode(char)}.
   * <p>
   * Method under test: {@link Json#setRatingCode(char)}
   */
  @Test
  @DisplayName("Test Json setRatingCode(char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRatingCode(char)"})
  void testJsonSetRatingCode() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRatingCode('A');

    // Assert
    assertEquals('A', json.ratingCode);
    assertTrue(json.ratingCodeIsSet);
  }

  /**
   * Test Json {@link Json#taxonomyExternalId()}.
   * <p>
   * Method under test: {@link Json#taxonomyExternalId()}
   */
  @Test
  @DisplayName("Test Json taxonomyExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.taxonomyExternalId()"})
  void testJsonTaxonomyExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).taxonomyExternalId());
  }
}
