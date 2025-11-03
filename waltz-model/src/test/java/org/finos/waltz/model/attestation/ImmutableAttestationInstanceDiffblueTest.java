package org.finos.waltz.model.attestation;

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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.attestation.ImmutableAttestationInstance.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestationInstance.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationInstanceDiffblueTest {
  /**
   * Test {@link ImmutableAttestationInstance#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAttestationInstance#builder()}
   *   <li>{@link ImmutableAttestationInstance#attestedAt(LocalDateTime)}
   *   <li>{@link ImmutableAttestationInstance#attestedBy(String)}
   *   <li>{@link ImmutableAttestationInstance#attestedEntityId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestedAt(LocalDateTime)", "Builder Builder.attestedBy(String)",
      "Builder Builder.attestedEntityId(Long)", "ImmutableAttestationInstance Builder.build()"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAttestationInstance.builder();
    Builder actualAttestedAtResult = actualBuilderResult.attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<? extends LocalDateTime> attestedAt = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    Builder actualAttestedByResult = actualAttestedAtResult.attestedAt(attestedAt).attestedBy("Attested By");
    Optional<String> attestedBy = Optional.of("foo");
    Builder actualIdResult = actualAttestedByResult.attestedBy(attestedBy).attestedEntityId(1L).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Test Builder {@link Builder#attestationRunId(Long)}.
   * <p>
   * Method under test: {@link Builder#attestationRunId(Long)}
   */
  @Test
  @DisplayName("Test Builder attestationRunId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestationRunId(Long)"})
  void testBuilderAttestationRunId() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestationRunId(1L));
  }

  /**
   * Test Builder {@link Builder#attestedAt(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#attestedAt(Optional)}
   */
  @Test
  @DisplayName("Test Builder attestedAt(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestedAt(Optional)"})
  void testBuilderAttestedAtWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();
    Optional<? extends LocalDateTime> attestedAt = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertSame(builderResult, builderResult.attestedAt(attestedAt));
  }

  /**
   * Test Builder {@link Builder#attestedBy(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#attestedBy(Optional)}
   */
  @Test
  @DisplayName("Test Builder attestedBy(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestedBy(Optional)"})
  void testBuilderAttestedByWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();
    Optional<String> attestedBy = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.attestedBy(attestedBy));
  }

  /**
   * Test Builder {@link Builder#attestedEntityKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#attestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder attestedEntityKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestedEntityKind(EntityKind)"})
  void testBuilderAttestedEntityKind() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestedEntityKind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#from(AttestationInstance)} with {@code AttestationInstance}.
   * <p>
   * Method under test: {@link Builder#from(AttestationInstance)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationInstance) with 'AttestationInstance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationInstance)"})
  void testBuilderFromWithAttestationInstance() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();
    AttestationInstance instance = mock(AttestationInstance.class);
    when(instance.parentEntity()).thenThrow(new IllegalStateException("instance"));
    when(instance.attestationRunId()).thenReturn(1L);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.attestedAt()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.attestedBy()).thenReturn(ofResult2);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestationRunId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).attestedEntityKind();
    verify(instance).parentEntity();
  }

  /**
   * Test Builder {@link Builder#from(AttestationInstance)} with {@code AttestationInstance}.
   * <p>
   * Method under test: {@link Builder#from(AttestationInstance)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationInstance) with 'AttestationInstance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationInstance)"})
  void testBuilderFromWithAttestationInstance2() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();
    AttestationInstance instance = mock(AttestationInstance.class);
    when(instance.attestedEntityId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.parentEntity()).thenReturn(mock(EntityReference.class));
    when(instance.attestationRunId()).thenReturn(1L);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.attestedAt()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.attestedBy()).thenReturn(ofResult3);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).attestationRunId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).parentEntity();
    ImmutableAttestationInstance buildResult = builderResult.build();
    assertEquals(1L, buildResult.attestationRunId().longValue());
    assertEquals(1L, buildResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationInstance)} with {@code AttestationInstance}.
   * <p>
   * Method under test: {@link Builder#from(AttestationInstance)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationInstance) with 'AttestationInstance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationInstance)"})
  void testBuilderFromWithAttestationInstance3() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();
    AttestationInstance instance = mock(AttestationInstance.class);
    when(instance.attestedEntityId()).thenThrow(new IllegalStateException("instance"));
    when(instance.parentEntity()).thenReturn(mock(EntityReference.class));
    when(instance.attestationRunId()).thenReturn(1L);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.attestedAt()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.attestedBy()).thenReturn(ofResult2);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestationRunId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).parentEntity();
  }

  /**
   * Test Builder {@link Builder#from(AttestationInstance)} with {@code AttestationInstance}.
   * <ul>
   *   <li>Then builder build attestedEntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationInstance)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationInstance) with 'AttestationInstance'; then builder build attestedEntityId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationInstance)"})
  void testBuilderFromWithAttestationInstance_thenBuilderBuildAttestedEntityIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();
    AttestationInstance instance = mock(AttestationInstance.class);
    when(instance.attestedEntityId()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.parentEntity()).thenReturn(mock(EntityReference.class));
    when(instance.attestationRunId()).thenReturn(1L);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.attestedAt()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.attestedBy()).thenReturn(ofResult3);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).attestationRunId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).parentEntity();
    ImmutableAttestationInstance buildResult = builderResult.build();
    assertNull(buildResult.attestedEntityId());
    assertEquals(1L, buildResult.attestationRunId().longValue());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationInstance)} with {@code AttestationInstance}.
   * <ul>
   *   <li>When {@link AttestationInstance} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationInstance)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationInstance) with 'AttestationInstance'; when AttestationInstance id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationInstance)"})
  void testBuilderFromWithAttestationInstance_whenAttestationInstanceIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();
    AttestationInstance instance = mock(AttestationInstance.class);
    when(instance.attestedEntityId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.parentEntity()).thenReturn(mock(EntityReference.class));
    when(instance.attestationRunId()).thenReturn(1L);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.attestedAt()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.attestedBy()).thenReturn(ofResult2);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).attestationRunId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).parentEntity();
    ImmutableAttestationInstance buildResult = builderResult.build();
    assertEquals(1L, buildResult.attestationRunId().longValue());
    assertEquals(1L, buildResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#parentEntity(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parentEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder parentEntity(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentEntity(EntityReference)"})
  void testBuilderParentEntity_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentEntity(mock(EntityReference.class)));
  }

  /**
   * Test Json {@link Json#attestationRunId()}.
   * <p>
   * Method under test: {@link Json#attestationRunId()}
   */
  @Test
  @DisplayName("Test Json attestationRunId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.attestationRunId()"})
  void testJsonAttestationRunId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestationRunId());
  }

  /**
   * Test Json {@link Json#attestedAt()}.
   * <p>
   * Method under test: {@link Json#attestedAt()}
   */
  @Test
  @DisplayName("Test Json attestedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.attestedAt()"})
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
  @MethodsUnderTest({"Optional Json.attestedBy()"})
  void testJsonAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestedBy());
  }

  /**
   * Test Json {@link Json#attestedEntityId()}.
   * <p>
   * Method under test: {@link Json#attestedEntityId()}
   */
  @Test
  @DisplayName("Test Json attestedEntityId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.attestedEntityId()"})
  void testJsonAttestedEntityId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestedEntityId());
  }

  /**
   * Test Json {@link Json#attestedEntityKind()}.
   * <p>
   * Method under test: {@link Json#attestedEntityKind()}
   */
  @Test
  @DisplayName("Test Json attestedEntityKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.attestedEntityKind()"})
  void testJsonAttestedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestedEntityKind());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
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
    assertNull(actualJson.attestationRunId);
    assertNull(actualJson.attestedEntityId);
    assertNull(actualJson.attestedEntityKind);
    assertNull(actualJson.parentEntity);
    assertFalse(actualJson.attestedAt.isPresent());
    assertFalse(actualJson.attestedBy.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#parentEntity()}.
   * <p>
   * Method under test: {@link Json#parentEntity()}
   */
  @Test
  @DisplayName("Test Json parentEntity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.parentEntity()"})
  void testJsonParentEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentEntity());
  }
}
