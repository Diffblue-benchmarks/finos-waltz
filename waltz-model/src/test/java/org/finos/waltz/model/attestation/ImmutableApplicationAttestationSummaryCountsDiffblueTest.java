package org.finos.waltz.model.attestation;

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
import java.util.HashSet;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationSummaryCounts.Builder;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationSummaryCounts.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationAttestationSummaryCountsDiffblueTest {
  /**
   * Test {@link ImmutableApplicationAttestationSummaryCounts#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApplicationAttestationSummaryCounts#builder()}
   *   <li>{@link ImmutableApplicationAttestationSummaryCounts#attestedId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestedId(Long)",
      "ImmutableApplicationAttestationSummaryCounts Builder.build()"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableApplicationAttestationSummaryCounts.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.attestedId(1L));
  }

  /**
   * Test Builder {@link Builder#addAllAttestationCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAttestationCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAttestationCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAttestationCounts(Iterable)"})
  void testBuilderAddAllAttestationCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAttestationCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAttestationCounts(AttestationCount)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableAttestationCount.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAttestationCounts(AttestationCount)}
   */
  @Test
  @DisplayName("Test Builder addAttestationCounts(AttestationCount) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAttestationCounts(AttestationCount)"})
  void testBuilderAddAttestationCountsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAttestationCounts(new ImmutableAttestationCount.Json()));
  }

  /**
   * Test Builder {@link Builder#addAttestationCounts(AttestationCount[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableAttestationCount.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAttestationCounts(AttestationCount[])}
   */
  @Test
  @DisplayName("Test Builder addAttestationCounts(AttestationCount[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAttestationCounts(AttestationCount[])"})
  void testBuilderAddAttestationCountsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAttestationCounts(new ImmutableAttestationCount.Json()));
  }

  /**
   * Test Builder {@link Builder#attestationCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#attestationCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder attestationCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestationCounts(Iterable)"})
  void testBuilderAttestationCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestationCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#attestedKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#attestedKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder attestedKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestedKind(EntityKind)"})
  void testBuilderAttestedKind() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();

    // Act
    Builder actualAttestedKindResult = builderResult.attestedKind(EntityKind.ALL);

    // Assert
    ImmutableApplicationAttestationSummaryCounts buildResult = builderResult.build();
    assertNull(buildResult.attestedId());
    assertEquals(EntityKind.ALL, buildResult.attestedKind());
    assertSame(builderResult, actualAttestedKindResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryCounts)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableAttestationCount.Json} (default constructor).</li>
   *   <li>Then builder build attestationCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationAttestationSummaryCounts)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationSummaryCounts); given HashSet() add Json (default constructor); then builder build attestationCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationSummaryCounts)"})
  void testBuilderFrom_givenHashSetAddJson_thenBuilderBuildAttestationCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();

    HashSet<AttestationCount> attestationCountSet = new HashSet<>();
    attestationCountSet.add(new ImmutableAttestationCount.Json());
    ApplicationAttestationSummaryCounts instance = mock(ApplicationAttestationSummaryCounts.class);
    when(instance.attestedId()).thenReturn(1L);
    when(instance.attestationCounts()).thenReturn(attestationCountSet);
    when(instance.attestedKind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestationCounts();
    verify(instance).attestedId();
    verify(instance).attestedKind();
    ImmutableApplicationAttestationSummaryCounts buildResult = builderResult.build();
    assertEquals(1, buildResult.attestationCounts().size());
    assertEquals(EntityKind.ALL, buildResult.attestedKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryCounts)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return build attestedId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationAttestationSummaryCounts)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationSummaryCounts); given HashSet(); then return build attestedId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationSummaryCounts)"})
  void testBuilderFrom_givenHashSet_thenReturnBuildAttestedIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();
    ApplicationAttestationSummaryCounts instance = mock(ApplicationAttestationSummaryCounts.class);
    when(instance.attestedId()).thenReturn(1L);
    when(instance.attestationCounts()).thenReturn(new HashSet<>());
    when(instance.attestedKind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestationCounts();
    verify(instance).attestedId();
    verify(instance).attestedKind();
    ImmutableApplicationAttestationSummaryCounts buildResult = actualFromResult.build();
    assertEquals(1L, buildResult.attestedId().longValue());
    assertEquals(1L, builderResult.build().attestedId().longValue());
    assertEquals(EntityKind.ALL, buildResult.attestedKind());
    assertTrue(buildResult.attestationCounts().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryCounts)}.
   * <ul>
   *   <li>Then return build attestedId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationAttestationSummaryCounts)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationSummaryCounts); then return build attestedId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationSummaryCounts)"})
  void testBuilderFrom_thenReturnBuildAttestedIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();
    ApplicationAttestationSummaryCounts instance = mock(ApplicationAttestationSummaryCounts.class);
    when(instance.attestedId()).thenReturn(null);
    when(instance.attestationCounts()).thenReturn(new HashSet<>());
    when(instance.attestedKind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestationCounts();
    verify(instance).attestedId();
    verify(instance).attestedKind();
    ImmutableApplicationAttestationSummaryCounts buildResult = actualFromResult.build();
    assertNull(buildResult.attestedId());
    assertNull(builderResult.build().attestedId());
    assertEquals(EntityKind.ALL, buildResult.attestedKind());
    assertTrue(buildResult.attestationCounts().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationSummaryCounts)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationAttestationSummaryCounts)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationSummaryCounts); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationSummaryCounts)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationSummaryCounts.builder();
    ApplicationAttestationSummaryCounts instance = mock(ApplicationAttestationSummaryCounts.class);
    when(instance.attestedId()).thenThrow(new IllegalStateException("instance"));
    when(instance.attestedKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestedId();
    verify(instance).attestedKind();
  }

  /**
   * Test Json {@link Json#attestationCounts()}.
   * <p>
   * Method under test: {@link Json#attestationCounts()}
   */
  @Test
  @DisplayName("Test Json attestationCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.attestationCounts()"})
  void testJsonAttestationCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestationCounts());
  }

  /**
   * Test Json {@link Json#attestedId()}.
   * <p>
   * Method under test: {@link Json#attestedId()}
   */
  @Test
  @DisplayName("Test Json attestedId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.attestedId()"})
  void testJsonAttestedId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestedId());
  }

  /**
   * Test Json {@link Json#attestedKind()}.
   * <p>
   * Method under test: {@link Json#attestedKind()}
   */
  @Test
  @DisplayName("Test Json attestedKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.attestedKind()"})
  void testJsonAttestedKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestedKind());
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
    assertNull(actualJson.attestedId);
    assertNull(actualJson.attestedKind);
    assertTrue(actualJson.attestationCounts.isEmpty());
  }
}
