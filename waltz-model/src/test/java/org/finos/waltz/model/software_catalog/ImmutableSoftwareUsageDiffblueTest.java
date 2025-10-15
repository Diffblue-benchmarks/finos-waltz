package org.finos.waltz.model.software_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareUsage.Builder;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareUsage.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSoftwareUsageDiffblueTest {
  /**
   * Test Builder {@link Builder#applicationId(long)}.
   *
   * <p>Method under test: {@link Builder#applicationId(long)}
   */
  @Test
  @DisplayName("Test Builder applicationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationId(long)"})
  void testBuilderApplicationId() {
    // Arrange
    Builder builderResult = ImmutableSoftwareUsage.builder();

    // Act
    Builder actualApplicationIdResult = builderResult.applicationId(1L);

    // Assert
    assertSame(builderResult, actualApplicationIdResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#licenceId(Long)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareUsage Builder.build()",
    "Builder Builder.licenceId(Long)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSoftwareUsage actualImmutableSoftwareUsage =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Assert
    assertEquals("Provenance", actualImmutableSoftwareUsage.provenance());
    assertEquals(1L, actualImmutableSoftwareUsage.licenceId().longValue());
    assertEquals(1L, actualImmutableSoftwareUsage.applicationId());
    assertEquals(1L, actualImmutableSoftwareUsage.softwarePackageId());
    assertEquals(1L, actualImmutableSoftwareUsage.softwareVersionId());
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutableSoftwareUsage.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider2() {
    // Arrange
    Builder builderResult = ImmutableSoftwareUsage.builder();
    ImmutableSoftwareUsage instance =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableSoftwareUsage actualImmutableSoftwareUsage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareUsage);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider3() {
    // Arrange
    Builder builderResult = ImmutableSoftwareUsage.builder();
    ImmutableSoftwareUsage instance =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(null)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableSoftwareUsage actualImmutableSoftwareUsage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareUsage);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SoftwareUsage)} with {@code SoftwareUsage}.
   *
   * <p>Method under test: {@link Builder#from(SoftwareUsage)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareUsage) with 'SoftwareUsage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwareUsage)"})
  void testBuilderFromWithSoftwareUsage() {
    // Arrange
    Builder builderResult = ImmutableSoftwareUsage.builder();
    ImmutableSoftwareUsage instance =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSoftwareUsage actualImmutableSoftwareUsage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareUsage);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SoftwareUsage)} with {@code SoftwareUsage}.
   *
   * <p>Method under test: {@link Builder#from(SoftwareUsage)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareUsage) with 'SoftwareUsage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwareUsage)"})
  void testBuilderFromWithSoftwareUsage2() {
    // Arrange
    Builder builderResult = ImmutableSoftwareUsage.builder();
    ImmutableSoftwareUsage instance =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(null)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSoftwareUsage actualImmutableSoftwareUsage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareUsage);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#softwarePackageId(long)}.
   *
   * <p>Method under test: {@link Builder#softwarePackageId(long)}
   */
  @Test
  @DisplayName("Test Builder softwarePackageId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.softwarePackageId(long)"})
  void testBuilderSoftwarePackageId() {
    // Arrange
    Builder builderResult = ImmutableSoftwareUsage.builder();

    // Act
    Builder actualSoftwarePackageIdResult = builderResult.softwarePackageId(1L);

    // Assert
    assertSame(builderResult, actualSoftwarePackageIdResult);
  }

  /**
   * Test Builder {@link Builder#softwareVersionId(long)}.
   *
   * <p>Method under test: {@link Builder#softwareVersionId(long)}
   */
  @Test
  @DisplayName("Test Builder softwareVersionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.softwareVersionId(long)"})
  void testBuilderSoftwareVersionId() {
    // Arrange
    Builder builderResult = ImmutableSoftwareUsage.builder();

    // Act
    Builder actualSoftwareVersionIdResult = builderResult.softwareVersionId(1L);

    // Assert
    assertSame(builderResult, actualSoftwareVersionIdResult);
  }

  /**
   * Test {@link ImmutableSoftwareUsage#copyOf(SoftwareUsage)}.
   *
   * <ul>
   *   <li>Then return {@code Provenance}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#copyOf(SoftwareUsage)}
   */
  @Test
  @DisplayName("Test copyOf(SoftwareUsage); then return 'Provenance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareUsage ImmutableSoftwareUsage.copyOf(SoftwareUsage)"})
  void testCopyOf_thenReturnProvenance() {
    // Arrange
    ImmutableSoftwareUsage instance =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Act
    ImmutableSoftwareUsage actualCopyOfResult = ImmutableSoftwareUsage.copyOf(instance);

    // Assert
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.licenceId().longValue());
    assertEquals(1L, actualCopyOfResult.applicationId());
    assertEquals(1L, actualCopyOfResult.softwarePackageId());
    assertEquals(1L, actualCopyOfResult.softwareVersionId());
  }

  /**
   * Test {@link ImmutableSoftwareUsage#equals(Object)}, and {@link
   * ImmutableSoftwareUsage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwareUsage#equals(Object)}
   *   <li>{@link ImmutableSoftwareUsage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareUsage.equals(Object)",
    "int ImmutableSoftwareUsage.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSoftwareUsage immutableSoftwareUsage =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();
    ImmutableSoftwareUsage immutableSoftwareUsage2 =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSoftwareUsage, immutableSoftwareUsage2);
    assertEquals(immutableSoftwareUsage.hashCode(), immutableSoftwareUsage2.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwareUsage#equals(Object)}, and {@link
   * ImmutableSoftwareUsage#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwareUsage#equals(Object)}
   *   <li>{@link ImmutableSoftwareUsage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareUsage.equals(Object)",
    "int ImmutableSoftwareUsage.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSoftwareUsage immutableSoftwareUsage =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSoftwareUsage, immutableSoftwareUsage);
    int expectedHashCodeResult = immutableSoftwareUsage.hashCode();
    assertEquals(expectedHashCodeResult, immutableSoftwareUsage.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwareUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareUsage.equals(Object)",
    "int ImmutableSoftwareUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSoftwareUsage immutableSoftwareUsage =
        ImmutableSoftwareUsage.builder()
            .applicationId(2L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSoftwareUsage,
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSoftwareUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareUsage.equals(Object)",
    "int ImmutableSoftwareUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSoftwareUsage immutableSoftwareUsage =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(2L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSoftwareUsage,
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSoftwareUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareUsage.equals(Object)",
    "int ImmutableSoftwareUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSoftwareUsage immutableSoftwareUsage =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("applicationId")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSoftwareUsage,
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSoftwareUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareUsage.equals(Object)",
    "int ImmutableSoftwareUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableSoftwareUsage immutableSoftwareUsage =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(2L)
            .softwareVersionId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSoftwareUsage,
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSoftwareUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareUsage.equals(Object)",
    "int ImmutableSoftwareUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableSoftwareUsage immutableSoftwareUsage =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(2L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSoftwareUsage,
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSoftwareUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareUsage.equals(Object)",
    "int ImmutableSoftwareUsage.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSoftwareUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareUsage.equals(Object)",
    "int ImmutableSoftwareUsage.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build(),
        "Different type to ImmutableSoftwareUsage");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwareUsage#toString()}
   *   <li>{@link ImmutableSoftwareUsage#applicationId()}
   *   <li>{@link ImmutableSoftwareUsage#licenceId()}
   *   <li>{@link ImmutableSoftwareUsage#provenance()}
   *   <li>{@link ImmutableSoftwareUsage#softwarePackageId()}
   *   <li>{@link ImmutableSoftwareUsage#softwareVersionId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableSoftwareUsage.applicationId()",
    "Long ImmutableSoftwareUsage.licenceId()",
    "String ImmutableSoftwareUsage.provenance()",
    "long ImmutableSoftwareUsage.softwarePackageId()",
    "long ImmutableSoftwareUsage.softwareVersionId()",
    "String ImmutableSoftwareUsage.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSoftwareUsage immutableSoftwareUsage =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Act
    String actualToStringResult = immutableSoftwareUsage.toString();
    long actualApplicationIdResult = immutableSoftwareUsage.applicationId();
    Long actualLicenceIdResult = immutableSoftwareUsage.licenceId();
    String actualProvenanceResult = immutableSoftwareUsage.provenance();
    long actualSoftwarePackageIdResult = immutableSoftwareUsage.softwarePackageId();
    long actualSoftwareVersionIdResult = immutableSoftwareUsage.softwareVersionId();

    // Assert
    assertEquals("Provenance", actualProvenanceResult);
    assertEquals(
        "SoftwareUsage{provenance=Provenance, applicationId=1, softwareVersionId=1, softwarePackageId=1,"
            + " licenceId=1}",
        actualToStringResult);
    assertEquals(1L, actualLicenceIdResult.longValue());
    assertEquals(1L, actualApplicationIdResult);
    assertEquals(1L, actualSoftwarePackageIdResult);
    assertEquals(1L, actualSoftwareVersionIdResult);
  }

  /**
   * Test Json {@link Json#applicationId()}.
   *
   * <p>Method under test: {@link Json#applicationId()}
   */
  @Test
  @DisplayName("Test Json applicationId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.applicationId()"})
  void testJsonApplicationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().applicationId());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setLicenceId(Long)}
   *   <li>{@link Json#setProvenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setLicenceId(Long)",
    "void Json.setProvenance(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setLicenceId(1L);
    actualJson.setProvenance("Provenance");

    // Assert
    assertEquals(1L, actualJson.licenceId.longValue());
  }

  /**
   * Test Json {@link Json#licenceId()}.
   *
   * <p>Method under test: {@link Json#licenceId()}
   */
  @Test
  @DisplayName("Test Json licenceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.licenceId()"})
  void testJsonLicenceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().licenceId());
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test Json {@link Json#setApplicationId(long)}.
   *
   * <p>Method under test: {@link Json#setApplicationId(long)}
   */
  @Test
  @DisplayName("Test Json setApplicationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setApplicationId(long)"})
  void testJsonSetApplicationId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setApplicationId(1L);

    // Assert
    assertEquals(1L, json.applicationId);
    assertTrue(json.applicationIdIsSet);
  }

  /**
   * Test Json {@link Json#setSoftwarePackageId(long)}.
   *
   * <p>Method under test: {@link Json#setSoftwarePackageId(long)}
   */
  @Test
  @DisplayName("Test Json setSoftwarePackageId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setSoftwarePackageId(long)"})
  void testJsonSetSoftwarePackageId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSoftwarePackageId(1L);

    // Assert
    assertEquals(1L, json.softwarePackageId);
    assertTrue(json.softwarePackageIdIsSet);
  }

  /**
   * Test Json {@link Json#setSoftwareVersionId(long)}.
   *
   * <p>Method under test: {@link Json#setSoftwareVersionId(long)}
   */
  @Test
  @DisplayName("Test Json setSoftwareVersionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setSoftwareVersionId(long)"})
  void testJsonSetSoftwareVersionId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSoftwareVersionId(1L);

    // Assert
    assertEquals(1L, json.softwareVersionId);
    assertTrue(json.softwareVersionIdIsSet);
  }

  /**
   * Test Json {@link Json#softwarePackageId()}.
   *
   * <p>Method under test: {@link Json#softwarePackageId()}
   */
  @Test
  @DisplayName("Test Json softwarePackageId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.softwarePackageId()"})
  void testJsonSoftwarePackageId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().softwarePackageId());
  }

  /**
   * Test Json {@link Json#softwareVersionId()}.
   *
   * <p>Method under test: {@link Json#softwareVersionId()}
   */
  @Test
  @DisplayName("Test Json softwareVersionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.softwareVersionId()"})
  void testJsonSoftwareVersionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().softwareVersionId());
  }

  /**
   * Test {@link ImmutableSoftwareUsage#withApplicationId(long)}.
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#withApplicationId(long)}
   */
  @Test
  @DisplayName("Test withApplicationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareUsage ImmutableSoftwareUsage.withApplicationId(long)"})
  void testWithApplicationId() {
    // Arrange
    ImmutableSoftwareUsage immutableSoftwareUsage =
        ImmutableSoftwareUsage.builder()
            .applicationId(42L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Act
    ImmutableSoftwareUsage actualWithApplicationIdResult =
        immutableSoftwareUsage.withApplicationId(42L);

    // Assert
    assertSame(immutableSoftwareUsage, actualWithApplicationIdResult);
  }

  /**
   * Test {@link ImmutableSoftwareUsage#withApplicationId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Provenance}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#withApplicationId(long)}
   */
  @Test
  @DisplayName("Test withApplicationId(long); then return 'Provenance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareUsage ImmutableSoftwareUsage.withApplicationId(long)"})
  void testWithApplicationId_thenReturnProvenance() {
    // Arrange and Act
    ImmutableSoftwareUsage actualWithApplicationIdResult =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build()
            .withApplicationId(42L);

    // Assert
    assertEquals("Provenance", actualWithApplicationIdResult.provenance());
    assertEquals(1L, actualWithApplicationIdResult.licenceId().longValue());
    assertEquals(1L, actualWithApplicationIdResult.softwarePackageId());
    assertEquals(1L, actualWithApplicationIdResult.softwareVersionId());
    assertEquals(42L, actualWithApplicationIdResult.applicationId());
  }

  /**
   * Test {@link ImmutableSoftwareUsage#withLicenceId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#withLicenceId(Long)}
   */
  @Test
  @DisplayName("Test withLicenceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareUsage ImmutableSoftwareUsage.withLicenceId(Long)"})
  void testWithLicenceId() {
    // Arrange
    ImmutableSoftwareUsage immutableSoftwareUsage =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Act
    ImmutableSoftwareUsage actualWithLicenceIdResult = immutableSoftwareUsage.withLicenceId(1L);

    // Assert
    assertSame(immutableSoftwareUsage, actualWithLicenceIdResult);
  }

  /**
   * Test {@link ImmutableSoftwareUsage#withLicenceId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Provenance}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#withLicenceId(Long)}
   */
  @Test
  @DisplayName("Test withLicenceId(Long); when forty-two; then return 'Provenance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareUsage ImmutableSoftwareUsage.withLicenceId(Long)"})
  void testWithLicenceId_whenFortyTwo_thenReturnProvenance() {
    // Arrange and Act
    ImmutableSoftwareUsage actualWithLicenceIdResult =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build()
            .withLicenceId(42L);

    // Assert
    assertEquals("Provenance", actualWithLicenceIdResult.provenance());
    assertEquals(1L, actualWithLicenceIdResult.applicationId());
    assertEquals(1L, actualWithLicenceIdResult.softwarePackageId());
    assertEquals(1L, actualWithLicenceIdResult.softwareVersionId());
    assertEquals(42L, actualWithLicenceIdResult.licenceId().longValue());
  }

  /**
   * Test {@link ImmutableSoftwareUsage#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareUsage ImmutableSoftwareUsage.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    ImmutableSoftwareUsage immutableSoftwareUsage =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("42")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build();

    // Act
    ImmutableSoftwareUsage actualWithProvenanceResult = immutableSoftwareUsage.withProvenance("42");

    // Assert
    assertSame(immutableSoftwareUsage, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableSoftwareUsage#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return provenance is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return provenance is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareUsage ImmutableSoftwareUsage.withProvenance(String)"})
  void testWithProvenance_thenReturnProvenanceIs42() {
    // Arrange and Act
    ImmutableSoftwareUsage actualWithProvenanceResult =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals(1L, actualWithProvenanceResult.licenceId().longValue());
    assertEquals(1L, actualWithProvenanceResult.applicationId());
    assertEquals(1L, actualWithProvenanceResult.softwarePackageId());
    assertEquals(1L, actualWithProvenanceResult.softwareVersionId());
  }

  /**
   * Test {@link ImmutableSoftwareUsage#withSoftwarePackageId(long)}.
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#withSoftwarePackageId(long)}
   */
  @Test
  @DisplayName("Test withSoftwarePackageId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareUsage ImmutableSoftwareUsage.withSoftwarePackageId(long)"})
  void testWithSoftwarePackageId() {
    // Arrange
    ImmutableSoftwareUsage immutableSoftwareUsage =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(42L)
            .softwareVersionId(1L)
            .build();

    // Act
    ImmutableSoftwareUsage actualWithSoftwarePackageIdResult =
        immutableSoftwareUsage.withSoftwarePackageId(42L);

    // Assert
    assertSame(immutableSoftwareUsage, actualWithSoftwarePackageIdResult);
  }

  /**
   * Test {@link ImmutableSoftwareUsage#withSoftwarePackageId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Provenance}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#withSoftwarePackageId(long)}
   */
  @Test
  @DisplayName("Test withSoftwarePackageId(long); then return 'Provenance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareUsage ImmutableSoftwareUsage.withSoftwarePackageId(long)"})
  void testWithSoftwarePackageId_thenReturnProvenance() {
    // Arrange and Act
    ImmutableSoftwareUsage actualWithSoftwarePackageIdResult =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build()
            .withSoftwarePackageId(42L);

    // Assert
    assertEquals("Provenance", actualWithSoftwarePackageIdResult.provenance());
    assertEquals(1L, actualWithSoftwarePackageIdResult.licenceId().longValue());
    assertEquals(1L, actualWithSoftwarePackageIdResult.applicationId());
    assertEquals(1L, actualWithSoftwarePackageIdResult.softwareVersionId());
    assertEquals(42L, actualWithSoftwarePackageIdResult.softwarePackageId());
  }

  /**
   * Test {@link ImmutableSoftwareUsage#withSoftwareVersionId(long)}.
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#withSoftwareVersionId(long)}
   */
  @Test
  @DisplayName("Test withSoftwareVersionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareUsage ImmutableSoftwareUsage.withSoftwareVersionId(long)"})
  void testWithSoftwareVersionId() {
    // Arrange
    ImmutableSoftwareUsage immutableSoftwareUsage =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(42L)
            .build();

    // Act
    ImmutableSoftwareUsage actualWithSoftwareVersionIdResult =
        immutableSoftwareUsage.withSoftwareVersionId(42L);

    // Assert
    assertSame(immutableSoftwareUsage, actualWithSoftwareVersionIdResult);
  }

  /**
   * Test {@link ImmutableSoftwareUsage#withSoftwareVersionId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Provenance}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareUsage#withSoftwareVersionId(long)}
   */
  @Test
  @DisplayName("Test withSoftwareVersionId(long); then return 'Provenance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareUsage ImmutableSoftwareUsage.withSoftwareVersionId(long)"})
  void testWithSoftwareVersionId_thenReturnProvenance() {
    // Arrange and Act
    ImmutableSoftwareUsage actualWithSoftwareVersionIdResult =
        ImmutableSoftwareUsage.builder()
            .applicationId(1L)
            .licenceId(1L)
            .provenance("Provenance")
            .softwarePackageId(1L)
            .softwareVersionId(1L)
            .build()
            .withSoftwareVersionId(42L);

    // Assert
    assertEquals("Provenance", actualWithSoftwareVersionIdResult.provenance());
    assertEquals(1L, actualWithSoftwareVersionIdResult.licenceId().longValue());
    assertEquals(1L, actualWithSoftwareVersionIdResult.applicationId());
    assertEquals(1L, actualWithSoftwareVersionIdResult.softwarePackageId());
    assertEquals(42L, actualWithSoftwareVersionIdResult.softwareVersionId());
  }
}
