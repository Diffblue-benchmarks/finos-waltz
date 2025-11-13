package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SurveyTemplateDiffblueTest {
  /**
   * Test {@link SurveyTemplate#createdAt()}.
   *
   * <ul>
   *   <li>Then return toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplate#createdAt()}
   */
  @Test
  @DisplayName("Test createdAt(); then return toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime SurveyTemplate.createdAt()"})
  void testCreatedAt_thenReturnToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualCreatedAtResult =
        ImmutableSurveyTemplate.builder()
            .createdAt(ofResult.atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .createdAt();

    // Assert
    assertEquals("00:00", actualCreatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualCreatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link SurveyTemplate#status()}.
   *
   * <ul>
   *   <li>Then return {@code DRAFT}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplate#status()}
   */
  @Test
  @DisplayName("Test status(); then return 'DRAFT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReleaseLifecycleStatus SurveyTemplate.status()"})
  void testStatus_thenReturnDraft() {
    // Arrange, Act and Assert
    assertEquals(
        ReleaseLifecycleStatus.DRAFT,
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .status());
  }

  /**
   * Test {@link SurveyTemplate#kind()}.
   *
   * <ul>
   *   <li>Then return {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplate#kind()}
   */
  @Test
  @DisplayName("Test kind(); then return 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind SurveyTemplate.kind()"})
  void testKind_thenReturnAll() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .kind());
  }
}
