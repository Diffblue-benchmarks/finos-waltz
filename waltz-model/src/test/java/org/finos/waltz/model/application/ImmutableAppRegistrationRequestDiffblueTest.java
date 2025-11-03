package org.finos.waltz.model.application;

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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.application.ImmutableAppRegistrationRequest.Builder;
import org.finos.waltz.model.application.ImmutableAppRegistrationRequest.Json;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppRegistrationRequestDiffblueTest {
  /**
   * Test {@link ImmutableAppRegistrationRequest#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAppRegistrationRequest#builder()}
   *   <li>{@link ImmutableAppRegistrationRequest#assetCode(String)}
   *   <li>{@link ImmutableAppRegistrationRequest#description(String)}
   *   <li>{@link ImmutableAppRegistrationRequest#parentAssetCode(String)}
   *   <li>{@link ImmutableAppRegistrationRequest#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assetCode(String)", "ImmutableAppRegistrationRequest Builder.build()",
      "Builder Builder.description(String)", "Builder Builder.parentAssetCode(String)",
      "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualAssetCodeResult = ImmutableAppRegistrationRequest.builder().assetCode("Asset Code");
    Optional<String> assetCode = Optional.of("foo");
    Builder actualParentAssetCodeResult = actualAssetCodeResult.assetCode(assetCode)
        .description("The characteristics of someone or something")
        .parentAssetCode("Parent Asset Code");
    Optional<String> parentAssetCode = Optional.of("foo");
    Builder actualParentAssetCodeResult2 = actualParentAssetCodeResult.parentAssetCode(parentAssetCode);

    // Assert
    assertSame(actualParentAssetCodeResult2, actualParentAssetCodeResult2.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#addAliases(String)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addAliases(String)}
   */
  @Test
  @DisplayName("Test Builder addAliases(String) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAliases(String)"})
  void testBuilderAddAliasesWithElement() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAliases("Element"));
  }

  /**
   * Test Builder {@link Builder#addAliases(String[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addAliases(String[])}
   */
  @Test
  @DisplayName("Test Builder addAliases(String[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAliases(String[])"})
  void testBuilderAddAliasesWithElements() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAliases("Elements"));
  }

  /**
   * Test Builder {@link Builder#addAllAliases(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAliases(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAliases(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAliases(Iterable)"})
  void testBuilderAddAllAliases_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAliases(elements));
  }

  /**
   * Test Builder {@link Builder#addAllAliases(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAliases(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAliases(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAliases(Iterable)"})
  void testBuilderAddAllAliases_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAliases(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllTags(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllTags(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTags(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllTags(Iterable)"})
  void testBuilderAddAllTags_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTags(elements));
  }

  /**
   * Test Builder {@link Builder#addAllTags(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllTags(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTags(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllTags(Iterable)"})
  void testBuilderAddAllTags_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTags(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addTags(String)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addTags(String)}
   */
  @Test
  @DisplayName("Test Builder addTags(String) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addTags(String)"})
  void testBuilderAddTagsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTags("Element"));
  }

  /**
   * Test Builder {@link Builder#addTags(String[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addTags(String[])}
   */
  @Test
  @DisplayName("Test Builder addTags(String[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addTags(String[])"})
  void testBuilderAddTagsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTags("Elements"));
  }

  /**
   * Test Builder {@link Builder#aliases(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#aliases(Iterable)}
   */
  @Test
  @DisplayName("Test Builder aliases(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.aliases(Iterable)"})
  void testBuilderAliases_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.aliases(elements));
  }

  /**
   * Test Builder {@link Builder#aliases(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#aliases(Iterable)}
   */
  @Test
  @DisplayName("Test Builder aliases(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.aliases(Iterable)"})
  void testBuilderAliases_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.aliases(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#applicationKind(ApplicationKind)}.
   * <p>
   * Method under test: {@link Builder#applicationKind(ApplicationKind)}
   */
  @Test
  @DisplayName("Test Builder applicationKind(ApplicationKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationKind(ApplicationKind)"})
  void testBuilderApplicationKind() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationKind(ApplicationKind.IN_HOUSE));
  }

  /**
   * Test Builder {@link Builder#assetCode(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#assetCode(Optional)}
   */
  @Test
  @DisplayName("Test Builder assetCode(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assetCode(Optional)"})
  void testBuilderAssetCodeWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    Optional<String> assetCode = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.assetCode(assetCode));
  }

  /**
   * Test Builder {@link Builder#businessCriticality(Criticality)}.
   * <p>
   * Method under test: {@link Builder#businessCriticality(Criticality)}
   */
  @Test
  @DisplayName("Test Builder businessCriticality(Criticality)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.businessCriticality(Criticality)"})
  void testBuilderBusinessCriticality() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.businessCriticality(Criticality.LOW));
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationRequest)} with {@code AppRegistrationRequest}.
   * <p>
   * Method under test: {@link Builder#from(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationRequest) with 'AppRegistrationRequest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationRequest)"})
  void testBuilderFromWithAppRegistrationRequest() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    ImmutableAppRegistrationRequest buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", builderResult.build().description());
    Set<String> aliasesResult = buildResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, buildResult.tags());
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationRequest)} with {@code AppRegistrationRequest}.
   * <p>
   * Method under test: {@link Builder#from(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationRequest) with 'AppRegistrationRequest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationRequest)"})
  void testBuilderFromWithAppRegistrationRequest2() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> emptyResult = Optional.empty();
    when(instance.assetCode()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    ImmutableAppRegistrationRequest buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", builderResult.build().description());
    Set<String> aliasesResult = buildResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, buildResult.tags());
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationRequest)} with {@code AppRegistrationRequest}.
   * <p>
   * Method under test: {@link Builder#from(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationRequest) with 'AppRegistrationRequest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationRequest)"})
  void testBuilderFromWithAppRegistrationRequest3() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.parentAssetCode()).thenReturn(emptyResult);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    ImmutableAppRegistrationRequest buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", builderResult.build().description());
    Set<String> aliasesResult = buildResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, buildResult.tags());
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationRequest)} with {@code AppRegistrationRequest}.
   * <ul>
   *   <li>Then return build aliases size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationRequest) with 'AppRegistrationRequest'; then return build aliases size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationRequest)"})
  void testBuilderFromWithAppRegistrationRequest_thenReturnBuildAliasesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("instance");
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(stringSet);
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    ImmutableAppRegistrationRequest buildResult = actualFromResult.build();
    Set<String> aliasesResult = buildResult.aliases();
    assertEquals(1, aliasesResult.size());
    Set<String> aliasesResult2 = builderResult.build().aliases();
    assertEquals(1, aliasesResult2.size());
    assertTrue(aliasesResult.contains("instance"));
    assertTrue(aliasesResult2.contains("instance"));
    assertTrue(buildResult.tags().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationRequest)} with {@code AppRegistrationRequest}.
   * <ul>
   *   <li>Then return build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationRequest) with 'AppRegistrationRequest'; then return build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationRequest)"})
  void testBuilderFromWithAppRegistrationRequest_thenReturnBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    ImmutableAppRegistrationRequest buildResult = actualFromResult.build();
    assertNull(buildResult.description());
    assertNull(builderResult.build().description());
    Set<String> aliasesResult = buildResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, buildResult.tags());
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationRequest)} with {@code AppRegistrationRequest}.
   * <ul>
   *   <li>Then return build tags size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationRequest) with 'AppRegistrationRequest'; then return build tags size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationRequest)"})
  void testBuilderFromWithAppRegistrationRequest_thenReturnBuildTagsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("instance");
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(stringSet);
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    Set<String> tagsResult = actualFromResult.build().tags();
    assertEquals(1, tagsResult.size());
    Set<String> tagsResult2 = builderResult.build().tags();
    assertEquals(1, tagsResult2.size());
    assertTrue(tagsResult.contains("instance"));
    assertTrue(tagsResult2.contains("instance"));
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationRequest)} with {@code AppRegistrationRequest}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationRequest) with 'AppRegistrationRequest'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationRequest)"})
  void testBuilderFromWithAppRegistrationRequest_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.organisationalUnitId()).thenThrow(new IllegalStateException("instance"));
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; given 'Provenance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_givenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#lifecyclePhase(LifecyclePhase)}.
   * <p>
   * Method under test: {@link Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test Builder lifecyclePhase(LifecyclePhase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lifecyclePhase(LifecyclePhase)"})
  void testBuilderLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
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
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#organisationalUnitId(long)}.
   * <p>
   * Method under test: {@link Builder#organisationalUnitId(long)}
   */
  @Test
  @DisplayName("Test Builder organisationalUnitId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.organisationalUnitId(long)"})
  void testBuilderOrganisationalUnitId() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.organisationalUnitId(1L));
  }

  /**
   * Test Builder {@link Builder#overallRating(RagRating)}.
   * <p>
   * Method under test: {@link Builder#overallRating(RagRating)}
   */
  @Test
  @DisplayName("Test Builder overallRating(RagRating)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.overallRating(RagRating)"})
  void testBuilderOverallRating() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overallRating(RagRating.R));
  }

  /**
   * Test Builder {@link Builder#parentAssetCode(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#parentAssetCode(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentAssetCode(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentAssetCode(Optional)"})
  void testBuilderParentAssetCodeWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();
    Optional<String> parentAssetCode = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.parentAssetCode(parentAssetCode));
  }

  /**
   * Test Builder {@link Builder#tags(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#tags(Iterable)}
   */
  @Test
  @DisplayName("Test Builder tags(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.tags(Iterable)"})
  void testBuilderTags_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.tags(elements));
  }

  /**
   * Test Builder {@link Builder#tags(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#tags(Iterable)}
   */
  @Test
  @DisplayName("Test Builder tags(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.tags(Iterable)"})
  void testBuilderTags_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.tags(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#aliases()}.
   * <p>
   * Method under test: {@link Json#aliases()}
   */
  @Test
  @DisplayName("Test Json aliases()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.aliases()"})
  void testJsonAliases() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).aliases());
  }

  /**
   * Test Json {@link Json#applicationKind()}.
   * <p>
   * Method under test: {@link Json#applicationKind()}
   */
  @Test
  @DisplayName("Test Json applicationKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApplicationKind Json.applicationKind()"})
  void testJsonApplicationKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).applicationKind());
  }

  /**
   * Test Json {@link Json#assetCode()}.
   * <p>
   * Method under test: {@link Json#assetCode()}
   */
  @Test
  @DisplayName("Test Json assetCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.assetCode()"})
  void testJsonAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assetCode());
  }

  /**
   * Test Json {@link Json#businessCriticality()}.
   * <p>
   * Method under test: {@link Json#businessCriticality()}
   */
  @Test
  @DisplayName("Test Json businessCriticality()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Criticality Json.businessCriticality()"})
  void testJsonBusinessCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).businessCriticality());
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
   * Test Json {@link Json#lifecyclePhase()}.
   * <p>
   * Method under test: {@link Json#lifecyclePhase()}
   */
  @Test
  @DisplayName("Test Json lifecyclePhase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase Json.lifecyclePhase()"})
  void testJsonLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lifecyclePhase());
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
   * <p>
   * Method under test: {@link Json#organisationalUnitId()}
   */
  @Test
  @DisplayName("Test Json organisationalUnitId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.organisationalUnitId()"})
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).organisationalUnitId());
  }

  /**
   * Test Json {@link Json#overallRating()}.
   * <p>
   * Method under test: {@link Json#overallRating()}
   */
  @Test
  @DisplayName("Test Json overallRating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RagRating Json.overallRating()"})
  void testJsonOverallRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).overallRating());
  }

  /**
   * Test Json {@link Json#parentAssetCode()}.
   * <p>
   * Method under test: {@link Json#parentAssetCode()}
   */
  @Test
  @DisplayName("Test Json parentAssetCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.parentAssetCode()"})
  void testJsonParentAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentAssetCode());
  }

  /**
   * Test Json {@link Json#provenance()}.
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
  }

  /**
   * Test Json {@link Json#setOrganisationalUnitId(long)}.
   * <p>
   * Method under test: {@link Json#setOrganisationalUnitId(long)}
   */
  @Test
  @DisplayName("Test Json setOrganisationalUnitId(long)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#tags()}
   */
  @Test
  @DisplayName("Test Json tags()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.tags()"})
  void testJsonTags() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).tags());
  }
}
