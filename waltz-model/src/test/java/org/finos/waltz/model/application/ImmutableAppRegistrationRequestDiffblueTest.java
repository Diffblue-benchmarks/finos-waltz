package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.application.ImmutableAppRegistrationRequest.Builder;
import org.finos.waltz.model.application.ImmutableAppRegistrationRequest.Json;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppRegistrationRequestDiffblueTest {
  /**
   * Test {@link ImmutableAppRegistrationRequest#assetCode()}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#assetCode()}
   */
  @Test
  @DisplayName("Test assetCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAppRegistrationRequest.assetCode()"})
  void testAssetCode() {
    // Arrange and Act
    Optional<String> actualAssetCodeResult =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build()
            .assetCode();

    // Assert
    assertEquals("Asset Code", actualAssetCodeResult.get());
    assertTrue(actualAssetCodeResult.isPresent());
  }

  /**
   * Test Builder {@link Builder#addAliases(String)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addAliases(String)}
   */
  @Test
  @DisplayName("Test Builder addAliases(String) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAliases(String)"})
  void testBuilderAddAliasesWithElement() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualAddAliasesResult = builderResult.addAliases("Element");

    // Assert
    assertSame(builderResult, actualAddAliasesResult);
  }

  /**
   * Test Builder {@link Builder#addAliases(String[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addAliases(String[])}
   */
  @Test
  @DisplayName("Test Builder addAliases(String[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAliases(String[])"})
  void testBuilderAddAliasesWithElements() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualAddAliasesResult = builderResult.addAliases("Elements");

    // Assert
    assertSame(builderResult, actualAddAliasesResult);
  }

  /**
   * Test Builder {@link Builder#addAllAliases(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAliases(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAliases(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAliases(Iterable)"})
  void testBuilderAddAllAliases_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualAddAllAliasesResult = builderResult.addAllAliases(elements);

    // Assert
    assertSame(builderResult, actualAddAllAliasesResult);
  }

  /**
   * Test Builder {@link Builder#addAllAliases(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAliases(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAliases(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAliases(Iterable)"})
  void testBuilderAddAllAliases_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualAddAllAliasesResult = builderResult.addAllAliases(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAliasesResult);
  }

  /**
   * Test Builder {@link Builder#addAllTags(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllTags(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllTags(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllTags(Iterable)"})
  void testBuilderAddAllTags_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualAddAllTagsResult = builderResult.addAllTags(elements);

    // Assert
    assertSame(builderResult, actualAddAllTagsResult);
  }

  /**
   * Test Builder {@link Builder#addAllTags(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllTags(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTags(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllTags(Iterable)"})
  void testBuilderAddAllTags_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualAddAllTagsResult = builderResult.addAllTags(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllTagsResult);
  }

  /**
   * Test Builder {@link Builder#addTags(String)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addTags(String)}
   */
  @Test
  @DisplayName("Test Builder addTags(String) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTags(String)"})
  void testBuilderAddTagsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualAddTagsResult = builderResult.addTags("Element");

    // Assert
    assertSame(builderResult, actualAddTagsResult);
  }

  /**
   * Test Builder {@link Builder#addTags(String[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addTags(String[])}
   */
  @Test
  @DisplayName("Test Builder addTags(String[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTags(String[])"})
  void testBuilderAddTagsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualAddTagsResult = builderResult.addTags("Elements");

    // Assert
    assertSame(builderResult, actualAddTagsResult);
  }

  /**
   * Test Builder {@link Builder#aliases(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#aliases(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder aliases(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.aliases(Iterable)"})
  void testBuilderAliases_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualAliasesResult = builderResult.aliases(elements);

    // Assert
    assertSame(builderResult, actualAliasesResult);
  }

  /**
   * Test Builder {@link Builder#aliases(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#aliases(Iterable)}
   */
  @Test
  @DisplayName("Test Builder aliases(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.aliases(Iterable)"})
  void testBuilderAliases_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualAliasesResult = builderResult.aliases(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAliasesResult);
  }

  /**
   * Test Builder {@link Builder#applicationKind(ApplicationKind)}.
   *
   * <p>Method under test: {@link Builder#applicationKind(ApplicationKind)}
   */
  @Test
  @DisplayName("Test Builder applicationKind(ApplicationKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationKind(ApplicationKind)"})
  void testBuilderApplicationKind() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualApplicationKindResult = builderResult.applicationKind(ApplicationKind.IN_HOUSE);

    // Assert
    assertSame(builderResult, actualApplicationKindResult);
  }

  /**
   * Test Builder {@link Builder#assetCode(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#assetCode(Optional)}
   */
  @Test
  @DisplayName("Test Builder assetCode(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assetCode(Optional)"})
  void testBuilderAssetCodeWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    Optional<String> assetCode = Optional.of("foo");

    // Act
    Builder actualAssetCodeResult = builderResult.assetCode(assetCode);

    // Assert
    assertSame(builderResult, actualAssetCodeResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#assetCode(String)}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#parentAssetCode(String)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.assetCode(String)",
    "ImmutableAppRegistrationRequest Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.parentAssetCode(String)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualAssetCodeResult =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code");
    Optional<String> assetCode = Optional.of("foo");
    Builder actualParentAssetCodeResult =
        actualAssetCodeResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code");
    Optional<String> parentAssetCode = Optional.of("foo");
    ImmutableAppRegistrationRequest actualImmutableAppRegistrationRequest =
        actualParentAssetCodeResult
            .parentAssetCode(parentAssetCode)
            .provenance("Provenance")
            .build();

    // Assert
    assertEquals("Name", actualImmutableAppRegistrationRequest.name());
    assertEquals("Provenance", actualImmutableAppRegistrationRequest.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableAppRegistrationRequest.description());
    assertEquals(1L, actualImmutableAppRegistrationRequest.organisationalUnitId());
    assertEquals(Criticality.LOW, actualImmutableAppRegistrationRequest.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualImmutableAppRegistrationRequest.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualImmutableAppRegistrationRequest.lifecyclePhase());
    assertEquals(RagRating.R, actualImmutableAppRegistrationRequest.overallRating());
    assertTrue(actualImmutableAppRegistrationRequest.aliases().isEmpty());
  }

  /**
   * Test Builder {@link Builder#businessCriticality(Criticality)}.
   *
   * <p>Method under test: {@link Builder#businessCriticality(Criticality)}
   */
  @Test
  @DisplayName("Test Builder businessCriticality(Criticality)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.businessCriticality(Criticality)"})
  void testBuilderBusinessCriticality() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualBusinessCriticalityResult = builderResult.businessCriticality(Criticality.LOW);

    // Assert
    assertSame(builderResult, actualBusinessCriticalityResult);
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationRequest)} with {@code AppRegistrationRequest}.
   *
   * <p>Method under test: {@link Builder#from(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationRequest) with 'AppRegistrationRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationRequest)"})
  void testBuilderFromWithAppRegistrationRequest() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    ImmutableAppRegistrationRequest instance =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableAppRegistrationRequest actualImmutableAppRegistrationRequest =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAppRegistrationRequest);
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationRequest)} with {@code AppRegistrationRequest}.
   *
   * <p>Method under test: {@link Builder#from(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationRequest) with 'AppRegistrationRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationRequest)"})
  void testBuilderFromWithAppRegistrationRequest2() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    Builder builderResult2 = ImmutableAppRegistrationRequest.builder();
    builderResult2.addAliases("instance");
    ImmutableAppRegistrationRequest instance =
        builderResult2
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableAppRegistrationRequest actualImmutableAppRegistrationRequest =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAppRegistrationRequest);
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationRequest)} with {@code AppRegistrationRequest}.
   *
   * <p>Method under test: {@link Builder#from(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationRequest) with 'AppRegistrationRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationRequest)"})
  void testBuilderFromWithAppRegistrationRequest3() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    Builder builderResult2 = ImmutableAppRegistrationRequest.builder();
    builderResult2.addTags("name");
    builderResult2.addAliases("instance");
    ImmutableAppRegistrationRequest instance =
        builderResult2
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppRegistrationRequest actualImmutableAppRegistrationRequest = builderResult.build();
    assertEquals(instance, actualImmutableAppRegistrationRequest);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationRequest)} with {@code AppRegistrationRequest}.
   *
   * <p>Method under test: {@link Builder#from(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationRequest) with 'AppRegistrationRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationRequest)"})
  void testBuilderFromWithAppRegistrationRequest4() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    ImmutableAppRegistrationRequest instance =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description(null)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableAppRegistrationRequest actualImmutableAppRegistrationRequest =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAppRegistrationRequest);
    ImmutableAppRegistrationRequest actualImmutableAppRegistrationRequest2 = builderResult.build();
    assertEquals(instance, actualImmutableAppRegistrationRequest2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    ImmutableAppRegistrationRequest instance =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableAppRegistrationRequest actualImmutableAppRegistrationRequest =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableAppRegistrationRequest);
    ImmutableAppRegistrationRequest actualImmutableAppRegistrationRequest2 = builderResult.build();
    assertEquals(instance, actualImmutableAppRegistrationRequest2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    ImmutableAppRegistrationRequest instance =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableAppRegistrationRequest actualImmutableAppRegistrationRequest =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableAppRegistrationRequest);
    ImmutableAppRegistrationRequest actualImmutableAppRegistrationRequest2 = builderResult.build();
    assertEquals(instance, actualImmutableAppRegistrationRequest2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
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
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
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
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    ImmutableAppRegistrationRequest instance =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableAppRegistrationRequest actualImmutableAppRegistrationRequest =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableAppRegistrationRequest);
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
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description(null)
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
  void testBuilderFromWithProvenanceProvider4() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    Builder builderResult2 = ImmutableAppRegistrationRequest.builder();
    builderResult2.addAliases("instance");
    ImmutableAppRegistrationRequest instance =
        builderResult2
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableAppRegistrationRequest actualImmutableAppRegistrationRequest =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableAppRegistrationRequest);
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
  void testBuilderFromWithProvenanceProvider5() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    Builder builderResult2 = ImmutableAppRegistrationRequest.builder();
    builderResult2.addTags("name");
    builderResult2.addAliases("instance");
    ImmutableAppRegistrationRequest instance =
        builderResult2
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableAppRegistrationRequest actualImmutableAppRegistrationRequest = builderResult.build();
    assertEquals(instance, actualImmutableAppRegistrationRequest);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#lifecyclePhase(LifecyclePhase)}.
   *
   * <p>Method under test: {@link Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test Builder lifecyclePhase(LifecyclePhase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lifecyclePhase(LifecyclePhase)"})
  void testBuilderLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualLifecyclePhaseResult = builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(builderResult, actualLifecyclePhaseResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#organisationalUnitId(long)}.
   *
   * <p>Method under test: {@link Builder#organisationalUnitId(long)}
   */
  @Test
  @DisplayName("Test Builder organisationalUnitId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.organisationalUnitId(long)"})
  void testBuilderOrganisationalUnitId() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualOrganisationalUnitIdResult = builderResult.organisationalUnitId(1L);

    // Assert
    assertSame(builderResult, actualOrganisationalUnitIdResult);
  }

  /**
   * Test Builder {@link Builder#overallRating(RagRating)}.
   *
   * <p>Method under test: {@link Builder#overallRating(RagRating)}
   */
  @Test
  @DisplayName("Test Builder overallRating(RagRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.overallRating(RagRating)"})
  void testBuilderOverallRating() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualOverallRatingResult = builderResult.overallRating(RagRating.R);

    // Assert
    assertSame(builderResult, actualOverallRatingResult);
  }

  /**
   * Test Builder {@link Builder#parentAssetCode(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#parentAssetCode(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentAssetCode(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentAssetCode(Optional)"})
  void testBuilderParentAssetCodeWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    Optional<String> parentAssetCode = Optional.of("foo");

    // Act
    Builder actualParentAssetCodeResult = builderResult.parentAssetCode(parentAssetCode);

    // Assert
    assertSame(builderResult, actualParentAssetCodeResult);
  }

  /**
   * Test Builder {@link Builder#tags(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#tags(Iterable)}
   */
  @Test
  @DisplayName("Test Builder tags(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.tags(Iterable)"})
  void testBuilderTags_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualTagsResult = builderResult.tags(elements);

    // Assert
    assertSame(builderResult, actualTagsResult);
  }

  /**
   * Test Builder {@link Builder#tags(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#tags(Iterable)}
   */
  @Test
  @DisplayName("Test Builder tags(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.tags(Iterable)"})
  void testBuilderTags_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act
    Builder actualTagsResult = builderResult.tags(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualTagsResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#copyOf(AppRegistrationRequest)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#copyOf(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test copyOf(AppRegistrationRequest); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.copyOf(AppRegistrationRequest)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableAppRegistrationRequest instance =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppRegistrationRequest actualCopyOfResult =
        ImmutableAppRegistrationRequest.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    Set<String> aliasesResult = actualCopyOfResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualCopyOfResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}, and {@link
   * ImmutableAppRegistrationRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppRegistrationRequest#equals(Object)}
   *   <li>{@link ImmutableAppRegistrationRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest2 =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableAppRegistrationRequest, immutableAppRegistrationRequest2);
    assertEquals(
        immutableAppRegistrationRequest.hashCode(), immutableAppRegistrationRequest2.hashCode());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}, and {@link
   * ImmutableAppRegistrationRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppRegistrationRequest#equals(Object)}
   *   <li>{@link ImmutableAppRegistrationRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableAppRegistrationRequest, immutableAppRegistrationRequest);
    int expectedHashCodeResult = immutableAppRegistrationRequest.hashCode();
    assertEquals(expectedHashCodeResult, immutableAppRegistrationRequest.hashCode());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    builderResult.addAliases("Name");
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        builderResult
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppRegistrationRequest,
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    builderResult.addTags("Name");
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        builderResult
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppRegistrationRequest,
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.INTERNALLY_HOSTED)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppRegistrationRequest,
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Name")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppRegistrationRequest,
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.MEDIUM)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppRegistrationRequest,
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.DEVELOPMENT)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppRegistrationRequest,
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Provenance")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppRegistrationRequest,
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(2L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppRegistrationRequest,
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.A)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppRegistrationRequest,
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppRegistrationRequest,
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppRegistrationRequest,
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationRequest.equals(Object)",
    "int ImmutableAppRegistrationRequest.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build(),
        "Different type to ImmutableAppRegistrationRequest");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppRegistrationRequest#aliases()}
   *   <li>{@link ImmutableAppRegistrationRequest#applicationKind()}
   *   <li>{@link ImmutableAppRegistrationRequest#businessCriticality()}
   *   <li>{@link ImmutableAppRegistrationRequest#description()}
   *   <li>{@link ImmutableAppRegistrationRequest#lifecyclePhase()}
   *   <li>{@link ImmutableAppRegistrationRequest#name()}
   *   <li>{@link ImmutableAppRegistrationRequest#organisationalUnitId()}
   *   <li>{@link ImmutableAppRegistrationRequest#overallRating()}
   *   <li>{@link ImmutableAppRegistrationRequest#provenance()}
   *   <li>{@link ImmutableAppRegistrationRequest#tags()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableAppRegistrationRequest.aliases()",
    "ApplicationKind ImmutableAppRegistrationRequest.applicationKind()",
    "Criticality ImmutableAppRegistrationRequest.businessCriticality()",
    "String ImmutableAppRegistrationRequest.description()",
    "LifecyclePhase ImmutableAppRegistrationRequest.lifecyclePhase()",
    "String ImmutableAppRegistrationRequest.name()",
    "long ImmutableAppRegistrationRequest.organisationalUnitId()",
    "RagRating ImmutableAppRegistrationRequest.overallRating()",
    "String ImmutableAppRegistrationRequest.provenance()",
    "Set ImmutableAppRegistrationRequest.tags()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    Set<String> actualAliasesResult = immutableAppRegistrationRequest.aliases();
    ApplicationKind actualApplicationKindResult = immutableAppRegistrationRequest.applicationKind();
    Criticality actualBusinessCriticalityResult =
        immutableAppRegistrationRequest.businessCriticality();
    String actualDescriptionResult = immutableAppRegistrationRequest.description();
    LifecyclePhase actualLifecyclePhaseResult = immutableAppRegistrationRequest.lifecyclePhase();
    String actualNameResult = immutableAppRegistrationRequest.name();
    long actualOrganisationalUnitIdResult = immutableAppRegistrationRequest.organisationalUnitId();
    RagRating actualOverallRatingResult = immutableAppRegistrationRequest.overallRating();
    String actualProvenanceResult = immutableAppRegistrationRequest.provenance();
    Set<String> actualTagsResult = immutableAppRegistrationRequest.tags();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("Provenance", actualProvenanceResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualOrganisationalUnitIdResult);
    assertEquals(Criticality.LOW, actualBusinessCriticalityResult);
    assertEquals(ApplicationKind.IN_HOUSE, actualApplicationKindResult);
    assertEquals(LifecyclePhase.PRODUCTION, actualLifecyclePhaseResult);
    assertEquals(RagRating.R, actualOverallRatingResult);
    assertTrue(actualAliasesResult.isEmpty());
    assertSame(actualAliasesResult, actualTagsResult);
  }

  /**
   * Test Json {@link Json#aliases()}.
   *
   * <p>Method under test: {@link Json#aliases()}
   */
  @Test
  @DisplayName("Test Json aliases()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.aliases()"})
  void testJsonAliases() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().aliases());
  }

  /**
   * Test Json {@link Json#applicationKind()}.
   *
   * <p>Method under test: {@link Json#applicationKind()}
   */
  @Test
  @DisplayName("Test Json applicationKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ApplicationKind Json.applicationKind()"})
  void testJsonApplicationKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().applicationKind());
  }

  /**
   * Test Json {@link Json#assetCode()}.
   *
   * <p>Method under test: {@link Json#assetCode()}
   */
  @Test
  @DisplayName("Test Json assetCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.assetCode()"})
  void testJsonAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assetCode());
  }

  /**
   * Test Json {@link Json#businessCriticality()}.
   *
   * <p>Method under test: {@link Json#businessCriticality()}
   */
  @Test
  @DisplayName("Test Json businessCriticality()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Criticality Json.businessCriticality()"})
  void testJsonBusinessCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().businessCriticality());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#lifecyclePhase()}.
   *
   * <p>Method under test: {@link Json#lifecyclePhase()}
   */
  @Test
  @DisplayName("Test Json lifecyclePhase()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LifecyclePhase Json.lifecyclePhase()"})
  void testJsonLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lifecyclePhase());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.businessCriticality);
    assertNull(actualJson.applicationKind);
    assertNull(actualJson.lifecyclePhase);
    assertNull(actualJson.overallRating);
    assertEquals(0L, actualJson.organisationalUnitId);
    assertFalse(actualJson.assetCode.isPresent());
    assertFalse(actualJson.parentAssetCode.isPresent());
    assertFalse(actualJson.organisationalUnitIdIsSet);
    assertTrue(actualJson.aliases.isEmpty());
    assertTrue(actualJson.tags.isEmpty());
  }

  /**
   * Test Json {@link Json#organisationalUnitId()}.
   *
   * <p>Method under test: {@link Json#organisationalUnitId()}
   */
  @Test
  @DisplayName("Test Json organisationalUnitId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.organisationalUnitId()"})
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().organisationalUnitId());
  }

  /**
   * Test Json {@link Json#overallRating()}.
   *
   * <p>Method under test: {@link Json#overallRating()}
   */
  @Test
  @DisplayName("Test Json overallRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RagRating Json.overallRating()"})
  void testJsonOverallRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overallRating());
  }

  /**
   * Test Json {@link Json#parentAssetCode()}.
   *
   * <p>Method under test: {@link Json#parentAssetCode()}
   */
  @Test
  @DisplayName("Test Json parentAssetCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.parentAssetCode()"})
  void testJsonParentAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentAssetCode());
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
   * Test Json {@link Json#setOrganisationalUnitId(long)}.
   *
   * <p>Method under test: {@link Json#setOrganisationalUnitId(long)}
   */
  @Test
  @DisplayName("Test Json setOrganisationalUnitId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setOrganisationalUnitId(long)"})
  void testJsonSetOrganisationalUnitId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setOrganisationalUnitId(1L);

    // Assert
    assertEquals(1L, json.organisationalUnitId);
    assertTrue(json.organisationalUnitIdIsSet);
  }

  /**
   * Test Json {@link Json#tags()}.
   *
   * <p>Method under test: {@link Json#tags()}
   */
  @Test
  @DisplayName("Test Json tags()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.tags()"})
  void testJsonTags() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#parentAssetCode()}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#parentAssetCode()}
   */
  @Test
  @DisplayName("Test parentAssetCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAppRegistrationRequest.parentAssetCode()"})
  void testParentAssetCode() {
    // Arrange and Act
    Optional<String> actualParentAssetCodeResult =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build()
            .parentAssetCode();

    // Assert
    assertEquals("Parent Asset Code", actualParentAssetCodeResult.get());
    assertTrue(actualParentAssetCodeResult.isPresent());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#toString()}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAppRegistrationRequest.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "AppRegistrationRequest{name=Name, provenance=Provenance, organisationalUnitId=1, applicationKind=IN_HOUSE,"
            + " lifecyclePhase=PRODUCTION, assetCode=Asset Code, parentAssetCode=Parent Asset Code, aliases=[],"
            + " tags=[], overallRating=R, businessCriticality=LOW}",
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withAliases(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withAliases(Iterable)}
   */
  @Test
  @DisplayName("Test withAliases(Iterable) with 'Iterable'; given 'Elements'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withAliases(Iterable)"
  })
  void testWithAliasesWithIterable_givenElements_thenReturnName() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    ImmutableAppRegistrationRequest actualWithAliasesResult =
        immutableAppRegistrationRequest.withAliases(elements);

    // Assert
    assertEquals("Name", actualWithAliasesResult.name());
    assertEquals("Provenance", actualWithAliasesResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithAliasesResult.description());
    assertEquals(1L, actualWithAliasesResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithAliasesResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithAliasesResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithAliasesResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithAliasesResult.overallRating());
    assertTrue(actualWithAliasesResult.tags().isEmpty());
    assertEquals(elements, actualWithAliasesResult.aliases());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withAliases(String[])} with {@code String[]}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withAliases(String[])}
   */
  @Test
  @DisplayName("Test withAliases(String[]) with 'String[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withAliases(String[])"
  })
  void testWithAliasesWithString() {
    // Arrange and Act
    ImmutableAppRegistrationRequest actualWithAliasesResult =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build()
            .withAliases("Elements");

    // Assert
    assertEquals("Name", actualWithAliasesResult.name());
    assertEquals("Provenance", actualWithAliasesResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithAliasesResult.description());
    Set<String> aliasesResult = actualWithAliasesResult.aliases();
    assertEquals(1, aliasesResult.size());
    assertEquals(1L, actualWithAliasesResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithAliasesResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithAliasesResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithAliasesResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithAliasesResult.overallRating());
    assertTrue(aliasesResult.contains("Elements"));
    assertTrue(actualWithAliasesResult.tags().isEmpty());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withApplicationKind(ApplicationKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableAppRegistrationRequest#withApplicationKind(ApplicationKind)}
   */
  @Test
  @DisplayName("Test withApplicationKind(ApplicationKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withApplicationKind(ApplicationKind)"
  })
  void testWithApplicationKind() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppRegistrationRequest actualWithApplicationKindResult =
        immutableAppRegistrationRequest.withApplicationKind(ApplicationKind.IN_HOUSE);

    // Assert
    assertSame(immutableAppRegistrationRequest, actualWithApplicationKindResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withApplicationKind(ApplicationKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAppRegistrationRequest#withApplicationKind(ApplicationKind)}
   */
  @Test
  @DisplayName("Test withApplicationKind(ApplicationKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withApplicationKind(ApplicationKind)"
  })
  void testWithApplicationKind_thenReturnName() {
    // Arrange and Act
    ImmutableAppRegistrationRequest actualWithApplicationKindResult =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.INTERNALLY_HOSTED)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build()
            .withApplicationKind(ApplicationKind.IN_HOUSE);

    // Assert
    assertEquals("Name", actualWithApplicationKindResult.name());
    assertEquals("Provenance", actualWithApplicationKindResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithApplicationKindResult.description());
    assertEquals(1L, actualWithApplicationKindResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithApplicationKindResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithApplicationKindResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithApplicationKindResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithApplicationKindResult.overallRating());
    Set<String> aliasesResult = actualWithApplicationKindResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualWithApplicationKindResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withAssetCode(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withAssetCode(Optional)}
   */
  @Test
  @DisplayName("Test withAssetCode(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withAssetCode(Optional)"
  })
  void testWithAssetCodeWithOptional() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableAppRegistrationRequest actualWithAssetCodeResult =
        immutableAppRegistrationRequest.withAssetCode(optional);

    // Assert
    assertEquals("Name", actualWithAssetCodeResult.name());
    assertEquals("Provenance", actualWithAssetCodeResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithAssetCodeResult.description());
    assertEquals(1L, actualWithAssetCodeResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithAssetCodeResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithAssetCodeResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithAssetCodeResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithAssetCodeResult.overallRating());
    Set<String> aliasesResult = actualWithAssetCodeResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualWithAssetCodeResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withAssetCode(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withAssetCode(String)}
   */
  @Test
  @DisplayName("Test withAssetCode(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withAssetCode(String)"
  })
  void testWithAssetCodeWithValue() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("42")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppRegistrationRequest actualWithAssetCodeResult =
        immutableAppRegistrationRequest.withAssetCode("42");

    // Assert
    assertSame(immutableAppRegistrationRequest, actualWithAssetCodeResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withAssetCode(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withAssetCode(String)}
   */
  @Test
  @DisplayName("Test withAssetCode(String) with 'value'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withAssetCode(String)"
  })
  void testWithAssetCodeWithValue_thenReturnName() {
    // Arrange and Act
    ImmutableAppRegistrationRequest actualWithAssetCodeResult =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build()
            .withAssetCode("42");

    // Assert
    assertEquals("Name", actualWithAssetCodeResult.name());
    assertEquals("Provenance", actualWithAssetCodeResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithAssetCodeResult.description());
    assertEquals(1L, actualWithAssetCodeResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithAssetCodeResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithAssetCodeResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithAssetCodeResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithAssetCodeResult.overallRating());
    Set<String> aliasesResult = actualWithAssetCodeResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualWithAssetCodeResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withBusinessCriticality(Criticality)}.
   *
   * <p>Method under test: {@link
   * ImmutableAppRegistrationRequest#withBusinessCriticality(Criticality)}
   */
  @Test
  @DisplayName("Test withBusinessCriticality(Criticality)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withBusinessCriticality(Criticality)"
  })
  void testWithBusinessCriticality() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppRegistrationRequest actualWithBusinessCriticalityResult =
        immutableAppRegistrationRequest.withBusinessCriticality(Criticality.LOW);

    // Assert
    assertSame(immutableAppRegistrationRequest, actualWithBusinessCriticalityResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withBusinessCriticality(Criticality)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAppRegistrationRequest#withBusinessCriticality(Criticality)}
   */
  @Test
  @DisplayName("Test withBusinessCriticality(Criticality); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withBusinessCriticality(Criticality)"
  })
  void testWithBusinessCriticality_thenReturnName() {
    // Arrange and Act
    ImmutableAppRegistrationRequest actualWithBusinessCriticalityResult =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.MEDIUM)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build()
            .withBusinessCriticality(Criticality.LOW);

    // Assert
    assertEquals("Name", actualWithBusinessCriticalityResult.name());
    assertEquals("Provenance", actualWithBusinessCriticalityResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithBusinessCriticalityResult.description());
    assertEquals(1L, actualWithBusinessCriticalityResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithBusinessCriticalityResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithBusinessCriticalityResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithBusinessCriticalityResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithBusinessCriticalityResult.overallRating());
    Set<String> aliasesResult = actualWithBusinessCriticalityResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualWithBusinessCriticalityResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppRegistrationRequest actualWithDescriptionResult =
        immutableAppRegistrationRequest.withDescription("42");

    // Assert
    assertEquals(immutableAppRegistrationRequest, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("42")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppRegistrationRequest actualWithDescriptionResult =
        immutableAppRegistrationRequest.withDescription("42");

    // Assert
    assertSame(immutableAppRegistrationRequest, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withLifecyclePhase(LifecyclePhase)}.
   *
   * <p>Method under test: {@link
   * ImmutableAppRegistrationRequest#withLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withLifecyclePhase(LifecyclePhase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withLifecyclePhase(LifecyclePhase)"
  })
  void testWithLifecyclePhase() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppRegistrationRequest actualWithLifecyclePhaseResult =
        immutableAppRegistrationRequest.withLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(immutableAppRegistrationRequest, actualWithLifecyclePhaseResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withLifecyclePhase(LifecyclePhase)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAppRegistrationRequest#withLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withLifecyclePhase(LifecyclePhase); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withLifecyclePhase(LifecyclePhase)"
  })
  void testWithLifecyclePhase_thenReturnName() {
    // Arrange and Act
    ImmutableAppRegistrationRequest actualWithLifecyclePhaseResult =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.DEVELOPMENT)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build()
            .withLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertEquals("Name", actualWithLifecyclePhaseResult.name());
    assertEquals("Provenance", actualWithLifecyclePhaseResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithLifecyclePhaseResult.description());
    assertEquals(1L, actualWithLifecyclePhaseResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithLifecyclePhaseResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithLifecyclePhaseResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithLifecyclePhaseResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithLifecyclePhaseResult.overallRating());
    Set<String> aliasesResult = actualWithLifecyclePhaseResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualWithLifecyclePhaseResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("42")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppRegistrationRequest actualWithNameResult =
        immutableAppRegistrationRequest.withName("42");

    // Assert
    assertSame(immutableAppRegistrationRequest, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableAppRegistrationRequest actualWithNameResult =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithNameResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithNameResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithNameResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithNameResult.overallRating());
    Set<String> aliasesResult = actualWithNameResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualWithNameResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withOrganisationalUnitId(long)}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withOrganisationalUnitId(long)}
   */
  @Test
  @DisplayName("Test withOrganisationalUnitId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withOrganisationalUnitId(long)"
  })
  void testWithOrganisationalUnitId() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(42L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppRegistrationRequest actualWithOrganisationalUnitIdResult =
        immutableAppRegistrationRequest.withOrganisationalUnitId(42L);

    // Assert
    assertSame(immutableAppRegistrationRequest, actualWithOrganisationalUnitIdResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withOrganisationalUnitId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withOrganisationalUnitId(long)}
   */
  @Test
  @DisplayName("Test withOrganisationalUnitId(long); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withOrganisationalUnitId(long)"
  })
  void testWithOrganisationalUnitId_thenReturnName() {
    // Arrange and Act
    ImmutableAppRegistrationRequest actualWithOrganisationalUnitIdResult =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build()
            .withOrganisationalUnitId(42L);

    // Assert
    assertEquals("Name", actualWithOrganisationalUnitIdResult.name());
    assertEquals("Provenance", actualWithOrganisationalUnitIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithOrganisationalUnitIdResult.description());
    assertEquals(42L, actualWithOrganisationalUnitIdResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithOrganisationalUnitIdResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithOrganisationalUnitIdResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithOrganisationalUnitIdResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithOrganisationalUnitIdResult.overallRating());
    Set<String> aliasesResult = actualWithOrganisationalUnitIdResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualWithOrganisationalUnitIdResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withOverallRating(RagRating)}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withOverallRating(RagRating)}
   */
  @Test
  @DisplayName("Test withOverallRating(RagRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withOverallRating(RagRating)"
  })
  void testWithOverallRating() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppRegistrationRequest actualWithOverallRatingResult =
        immutableAppRegistrationRequest.withOverallRating(RagRating.R);

    // Assert
    assertSame(immutableAppRegistrationRequest, actualWithOverallRatingResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withOverallRating(RagRating)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withOverallRating(RagRating)}
   */
  @Test
  @DisplayName("Test withOverallRating(RagRating); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withOverallRating(RagRating)"
  })
  void testWithOverallRating_thenReturnName() {
    // Arrange and Act
    ImmutableAppRegistrationRequest actualWithOverallRatingResult =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.A)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build()
            .withOverallRating(RagRating.R);

    // Assert
    assertEquals("Name", actualWithOverallRatingResult.name());
    assertEquals("Provenance", actualWithOverallRatingResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithOverallRatingResult.description());
    assertEquals(1L, actualWithOverallRatingResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithOverallRatingResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithOverallRatingResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithOverallRatingResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithOverallRatingResult.overallRating());
    Set<String> aliasesResult = actualWithOverallRatingResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualWithOverallRatingResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withParentAssetCode(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withParentAssetCode(Optional)}
   */
  @Test
  @DisplayName("Test withParentAssetCode(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withParentAssetCode(Optional)"
  })
  void testWithParentAssetCodeWithOptional() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableAppRegistrationRequest actualWithParentAssetCodeResult =
        immutableAppRegistrationRequest.withParentAssetCode(optional);

    // Assert
    assertEquals("Name", actualWithParentAssetCodeResult.name());
    assertEquals("Provenance", actualWithParentAssetCodeResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithParentAssetCodeResult.description());
    assertEquals(1L, actualWithParentAssetCodeResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithParentAssetCodeResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithParentAssetCodeResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithParentAssetCodeResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithParentAssetCodeResult.overallRating());
    Set<String> aliasesResult = actualWithParentAssetCodeResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualWithParentAssetCodeResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withParentAssetCode(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withParentAssetCode(String)}
   */
  @Test
  @DisplayName("Test withParentAssetCode(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withParentAssetCode(String)"
  })
  void testWithParentAssetCodeWithValue() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("42")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppRegistrationRequest actualWithParentAssetCodeResult =
        immutableAppRegistrationRequest.withParentAssetCode("42");

    // Assert
    assertSame(immutableAppRegistrationRequest, actualWithParentAssetCodeResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withParentAssetCode(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withParentAssetCode(String)}
   */
  @Test
  @DisplayName("Test withParentAssetCode(String) with 'value'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withParentAssetCode(String)"
  })
  void testWithParentAssetCodeWithValue_thenReturnName() {
    // Arrange and Act
    ImmutableAppRegistrationRequest actualWithParentAssetCodeResult =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build()
            .withParentAssetCode("42");

    // Assert
    assertEquals("Name", actualWithParentAssetCodeResult.name());
    assertEquals("Provenance", actualWithParentAssetCodeResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithParentAssetCodeResult.description());
    assertEquals(1L, actualWithParentAssetCodeResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithParentAssetCodeResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithParentAssetCodeResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithParentAssetCodeResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithParentAssetCodeResult.overallRating());
    Set<String> aliasesResult = actualWithParentAssetCodeResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualWithParentAssetCodeResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("42")
            .build();

    // Act
    ImmutableAppRegistrationRequest actualWithProvenanceResult =
        immutableAppRegistrationRequest.withProvenance("42");

    // Assert
    assertSame(immutableAppRegistrationRequest, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return provenance is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return provenance is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withProvenance(String)"
  })
  void testWithProvenance_thenReturnProvenanceIs42() {
    // Arrange and Act
    ImmutableAppRegistrationRequest actualWithProvenanceResult =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, actualWithProvenanceResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithProvenanceResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithProvenanceResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithProvenanceResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithProvenanceResult.overallRating());
    Set<String> aliasesResult = actualWithProvenanceResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualWithProvenanceResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withTags(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withTags(Iterable)}
   */
  @Test
  @DisplayName("Test withTags(Iterable) with 'Iterable'; given 'Elements'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withTags(Iterable)"
  })
  void testWithTagsWithIterable_givenElements_thenReturnName() {
    // Arrange
    ImmutableAppRegistrationRequest immutableAppRegistrationRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    ImmutableAppRegistrationRequest actualWithTagsResult =
        immutableAppRegistrationRequest.withTags(elements);

    // Assert
    assertEquals("Name", actualWithTagsResult.name());
    assertEquals("Provenance", actualWithTagsResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithTagsResult.description());
    assertEquals(1L, actualWithTagsResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithTagsResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithTagsResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithTagsResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithTagsResult.overallRating());
    assertTrue(actualWithTagsResult.aliases().isEmpty());
    assertEquals(elements, actualWithTagsResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationRequest#withTags(String[])} with {@code String[]}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationRequest#withTags(String[])}
   */
  @Test
  @DisplayName("Test withTags(String[]) with 'String[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationRequest ImmutableAppRegistrationRequest.withTags(String[])"
  })
  void testWithTagsWithString() {
    // Arrange and Act
    ImmutableAppRegistrationRequest actualWithTagsResult =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build()
            .withTags("Elements");

    // Assert
    assertEquals("Name", actualWithTagsResult.name());
    assertEquals("Provenance", actualWithTagsResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithTagsResult.description());
    Set<String> tagsResult = actualWithTagsResult.tags();
    assertEquals(1, tagsResult.size());
    assertEquals(1L, actualWithTagsResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualWithTagsResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualWithTagsResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithTagsResult.lifecyclePhase());
    assertEquals(RagRating.R, actualWithTagsResult.overallRating());
    assertTrue(tagsResult.contains("Elements"));
    assertTrue(actualWithTagsResult.aliases().isEmpty());
  }
}
