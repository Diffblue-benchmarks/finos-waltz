package org.finos.waltz.model.source_data_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.model.source_data_rating.ImmutableSourceDataRating.Builder;
import org.finos.waltz.model.source_data_rating.ImmutableSourceDataRating.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSourceDataRatingDiffblueTest {
  /**
   * Test {@link ImmutableSourceDataRating#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSourceDataRating#builder()}
   *   <li>{@link ImmutableSourceDataRating#lastImportDate(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSourceDataRating Builder.build()", "Builder Builder.lastImportDate(LocalDateTime)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSourceDataRating.builder();
    Builder actualLastImportDateResult = actualBuilderResult.lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<? extends LocalDateTime> lastImportDate = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastImportDateResult, actualLastImportDateResult.lastImportDate(lastImportDate));
  }

  /**
   * Test Builder {@link Builder#accuracy(RagRating)}.
   * <p>
   * Method under test: {@link Builder#accuracy(RagRating)}
   */
  @Test
  @DisplayName("Test Builder accuracy(RagRating)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.accuracy(RagRating)"})
  void testBuilderAccuracy() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.accuracy(RagRating.R));
  }

  /**
   * Test Builder {@link Builder#authoritativeness(RagRating)}.
   * <p>
   * Method under test: {@link Builder#authoritativeness(RagRating)}
   */
  @Test
  @DisplayName("Test Builder authoritativeness(RagRating)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.authoritativeness(RagRating)"})
  void testBuilderAuthoritativeness() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.authoritativeness(RagRating.R));
  }

  /**
   * Test Builder {@link Builder#completeness(RagRating)}.
   * <p>
   * Method under test: {@link Builder#completeness(RagRating)}
   */
  @Test
  @DisplayName("Test Builder completeness(RagRating)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.completeness(RagRating)"})
  void testBuilderCompleteness() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.completeness(RagRating.R));
  }

  /**
   * Test Builder {@link Builder#entityKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#entityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder entityKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityKind(EntityKind)"})
  void testBuilderEntityKind() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityKind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#from(SourceDataRating)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link SourceDataRating} {@link SourceDataRating#lastImportDate()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SourceDataRating)}
   */
  @Test
  @DisplayName("Test Builder from(SourceDataRating); given empty; when SourceDataRating lastImportDate() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SourceDataRating)"})
  void testBuilderFrom_givenEmpty_whenSourceDataRatingLastImportDateReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();
    SourceDataRating instance = mock(SourceDataRating.class);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.lastImportDate()).thenReturn(emptyResult);
    when(instance.completeness()).thenReturn(RagRating.R);
    when(instance.accuracy()).thenReturn(RagRating.R);
    when(instance.authoritativeness()).thenReturn(RagRating.R);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.sourceName()).thenReturn("Source Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).accuracy();
    verify(instance).authoritativeness();
    verify(instance).completeness();
    verify(instance).entityKind();
    verify(instance).lastImportDate();
    verify(instance).sourceName();
    ImmutableSourceDataRating buildResult = builderResult.build();
    assertEquals("Source Name", buildResult.sourceName());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(RagRating.R, buildResult.accuracy());
    assertEquals(RagRating.R, buildResult.authoritativeness());
    assertEquals(RagRating.R, buildResult.completeness());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SourceDataRating)}.
   * <ul>
   *   <li>Given {@link LocalDate} with {@code 1970} and one and one atStartOfDay.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SourceDataRating)}
   */
  @Test
  @DisplayName("Test Builder from(SourceDataRating); given LocalDate with '1970' and one and one atStartOfDay")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SourceDataRating)"})
  void testBuilderFrom_givenLocalDateWith1970AndOneAndOneAtStartOfDay() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();
    SourceDataRating instance = mock(SourceDataRating.class);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastImportDate()).thenReturn(ofResult);
    when(instance.completeness()).thenReturn(RagRating.R);
    when(instance.accuracy()).thenReturn(RagRating.R);
    when(instance.authoritativeness()).thenReturn(RagRating.R);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.sourceName()).thenReturn("Source Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).accuracy();
    verify(instance).authoritativeness();
    verify(instance).completeness();
    verify(instance).entityKind();
    verify(instance).lastImportDate();
    verify(instance).sourceName();
    ImmutableSourceDataRating buildResult = builderResult.build();
    assertEquals("Source Name", buildResult.sourceName());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(RagRating.R, buildResult.accuracy());
    assertEquals(RagRating.R, buildResult.authoritativeness());
    assertEquals(RagRating.R, buildResult.completeness());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SourceDataRating)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SourceDataRating)}
   */
  @Test
  @DisplayName("Test Builder from(SourceDataRating); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SourceDataRating)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();
    SourceDataRating instance = mock(SourceDataRating.class);
    when(instance.lastImportDate()).thenThrow(new IllegalStateException("instance"));
    when(instance.completeness()).thenReturn(RagRating.R);
    when(instance.accuracy()).thenReturn(RagRating.R);
    when(instance.authoritativeness()).thenReturn(RagRating.R);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.sourceName()).thenReturn("Source Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).accuracy();
    verify(instance).authoritativeness();
    verify(instance).completeness();
    verify(instance).entityKind();
    verify(instance).lastImportDate();
    verify(instance).sourceName();
  }

  /**
   * Test Builder {@link Builder#lastImportDate(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#lastImportDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder lastImportDate(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastImportDate(Optional)"})
  void testBuilderLastImportDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();
    Optional<? extends LocalDateTime> lastImportDate = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertSame(builderResult, builderResult.lastImportDate(lastImportDate));
  }

  /**
   * Test Builder {@link Builder#sourceName(String)}.
   * <p>
   * Method under test: {@link Builder#sourceName(String)}
   */
  @Test
  @DisplayName("Test Builder sourceName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.sourceName(String)"})
  void testBuilderSourceName() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceName("Source Name"));
  }

  /**
   * Test Json {@link Json#accuracy()}.
   * <p>
   * Method under test: {@link Json#accuracy()}
   */
  @Test
  @DisplayName("Test Json accuracy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RagRating Json.accuracy()"})
  void testJsonAccuracy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).accuracy());
  }

  /**
   * Test Json {@link Json#authoritativeness()}.
   * <p>
   * Method under test: {@link Json#authoritativeness()}
   */
  @Test
  @DisplayName("Test Json authoritativeness()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RagRating Json.authoritativeness()"})
  void testJsonAuthoritativeness() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).authoritativeness());
  }

  /**
   * Test Json {@link Json#completeness()}.
   * <p>
   * Method under test: {@link Json#completeness()}
   */
  @Test
  @DisplayName("Test Json completeness()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RagRating Json.completeness()"})
  void testJsonCompleteness() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).completeness());
  }

  /**
   * Test Json {@link Json#entityKind()}.
   * <p>
   * Method under test: {@link Json#entityKind()}
   */
  @Test
  @DisplayName("Test Json entityKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.entityKind()"})
  void testJsonEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityKind());
  }

  /**
   * Test Json {@link Json#lastImportDate()}.
   * <p>
   * Method under test: {@link Json#lastImportDate()}
   */
  @Test
  @DisplayName("Test Json lastImportDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.lastImportDate()"})
  void testJsonLastImportDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastImportDate());
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
    assertNull(actualJson.sourceName);
    assertNull(actualJson.entityKind);
    assertNull(actualJson.accuracy);
    assertNull(actualJson.authoritativeness);
    assertNull(actualJson.completeness);
    assertFalse(actualJson.lastImportDate.isPresent());
  }

  /**
   * Test Json {@link Json#sourceName()}.
   * <p>
   * Method under test: {@link Json#sourceName()}
   */
  @Test
  @DisplayName("Test Json sourceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.sourceName()"})
  void testJsonSourceName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).sourceName());
  }
}
