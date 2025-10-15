package org.finos.waltz.model.server_information;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LifecycleStatus;
import org.finos.waltz.model.server_information.ImmutableServerInformation.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerInformationDiffblueTest {
  /**
   * Test {@link ServerInformation#provenance()}.
   *
   * <p>Method under test: {@link ServerInformation#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ServerInformation.provenance()"})
  void testProvenance() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertEquals(
        "Provenance",
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .provenance());
  }

  /**
   * Test {@link ServerInformation#virtual()}.
   *
   * <p>Method under test: {@link ServerInformation#virtual()}
   */
  @Test
  @DisplayName("Test virtual()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerInformation.virtual()"})
  void testVirtual() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertFalse(
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .virtual());
  }

  /**
   * Test {@link ServerInformation#kind()}.
   *
   * <p>Method under test: {@link ServerInformation#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ServerInformation.kind()"})
  void testKind() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .kind());
  }

  /**
   * Test {@link ServerInformation#entityReference()}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInformation#entityReference()}
   */
  @Test
  @DisplayName("Test entityReference(); then return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference ServerInformation.entityReference()"})
  void testEntityReference_thenReturnImmutableEntityReference() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    EntityReference actualEntityReferenceResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertNull(actualEntityReferenceResult.description());
    assertEquals(1L, actualEntityReferenceResult.id());
    assertEquals(EntityKind.SERVER, actualEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualEntityReferenceResult.entityLifecycleStatus());
  }
}
