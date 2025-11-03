package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationEntry.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationEntry.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationEntryDiffblueTest {
  /**
   * Test {@link ImmutableAttestationEntry#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAttestationEntry#builder()}
   *   <li>{@link ImmutableAttestationEntry#attestedAt(LocalDateTime)}
   *   <li>{@link ImmutableAttestationEntry#attestedBy(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestedAt(LocalDateTime)", "Builder Builder.attestedBy(String)",
      "ImmutableAttestationEntry Builder.build()"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAttestationEntry.builder();
    Builder actualAttestedAtResult = actualBuilderResult.attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualAttestedAtResult, actualAttestedAtResult.attestedBy("Attested By"));
  }

  /**
   * Test Builder {@link Builder#appId(long)}.
   * <p>
   * Method under test: {@link Builder#appId(long)}
   */
  @Test
  @DisplayName("Test Builder appId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appId(long)"})
  void testBuilderAppId() {
    // Arrange
    Builder builderResult = ImmutableAttestationEntry.builder();

    // Act
    Builder actualAppIdResult = builderResult.appId(1L);

    // Assert
    ImmutableAttestationEntry buildResult = builderResult.build();
    assertNull(buildResult.attestedBy());
    assertNull(buildResult.attestedAt());
    assertEquals(1L, buildResult.appId());
    assertSame(builderResult, actualAppIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationEntry)}.
   * <ul>
   *   <li>Given {@code Attested By}.</li>
   *   <li>Then builder build attestedBy is {@code Attested By}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationEntry)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationEntry); given 'Attested By'; then builder build attestedBy is 'Attested By'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationEntry)"})
  void testBuilderFrom_givenAttestedBy_thenBuilderBuildAttestedByIsAttestedBy() {
    // Arrange
    Builder builderResult = ImmutableAttestationEntry.builder();
    AttestationEntry instance = mock(AttestationEntry.class);
    when(instance.attestedBy()).thenReturn("Attested By");
    when(instance.attestedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.appId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    ImmutableAttestationEntry buildResult = builderResult.build();
    assertEquals("Attested By", buildResult.attestedBy());
    assertEquals(1L, buildResult.appId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationEntry)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then builder build attestedBy is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationEntry)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationEntry); given 'null'; then builder build attestedBy is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationEntry)"})
  void testBuilderFrom_givenNull_thenBuilderBuildAttestedByIsNull() {
    // Arrange
    Builder builderResult = ImmutableAttestationEntry.builder();
    AttestationEntry instance = mock(AttestationEntry.class);
    when(instance.attestedBy()).thenReturn(null);
    when(instance.attestedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.appId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    ImmutableAttestationEntry buildResult = builderResult.build();
    assertNull(buildResult.attestedBy());
    assertEquals(1L, buildResult.appId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Json {@link Json#appId()}.
   * <p>
   * Method under test: {@link Json#appId()}
   */
  @Test
  @DisplayName("Test Json appId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.appId()"})
  void testJsonAppId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appId());
  }

  /**
   * Test Json {@link Json#attestedAt()}.
   * <p>
   * Method under test: {@link Json#attestedAt()}
   */
  @Test
  @DisplayName("Test Json attestedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.attestedAt()"})
  void testJsonAttestedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestedAt());
  }

  /**
   * Test Json {@link Json#attestedBy()}.
   * <p>
   * Method under test: {@link Json#attestedBy()}
   */
  @Test
  @DisplayName("Test Json attestedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.attestedBy()"})
  void testJsonAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestedBy());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAttestedAt(LocalDateTime)}
   *   <li>{@link Json#setAttestedBy(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAttestedAt(LocalDateTime)", "void Json.setAttestedBy(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setAttestedAt(ofResult.atStartOfDay());
    actualJson.setAttestedBy("Attested By");

    // Assert
    LocalDateTime localDateTime = actualJson.attestedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#setAppId(long)}.
   * <p>
   * Method under test: {@link Json#setAppId(long)}
   */
  @Test
  @DisplayName("Test Json setAppId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setAppId(long)"})
  void testJsonSetAppId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAppId(1L);

    // Assert
    assertEquals(1L, json.appId);
    assertTrue(json.appIdIsSet);
  }
}
