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
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.attestation.ImmutableAttestationInstanceRecipient.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestationInstanceRecipient.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationInstanceRecipientDiffblueTest {
  /**
   * Test Builder {@link Builder#attestationInstance(AttestationInstance)}.
   * <ul>
   *   <li>When {@link ImmutableAttestationInstance.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#attestationInstance(AttestationInstance)}
   */
  @Test
  @DisplayName("Test Builder attestationInstance(AttestationInstance); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestationInstance(AttestationInstance)"})
  void testBuilderAttestationInstance_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestationInstance(new ImmutableAttestationInstance.Json()));
  }

  /**
   * Test Builder {@link Builder#from(AttestationInstanceRecipient)} with {@code AttestationInstanceRecipient}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationInstanceRecipient)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationInstanceRecipient) with 'AttestationInstanceRecipient'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationInstanceRecipient)"})
  void testBuilderFromWithAttestationInstanceRecipient_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
    AttestationInstanceRecipient instance = mock(AttestationInstanceRecipient.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.userId()).thenReturn("42");
    ImmutableAttestationInstance.Json json = new ImmutableAttestationInstance.Json();
    when(instance.attestationInstance()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).attestationInstance();
    verify(instance).userId();
    ImmutableAttestationInstanceRecipient buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertSame(json, buildResult.attestationInstance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationInstanceRecipient)} with {@code AttestationInstanceRecipient}.
   * <ul>
   *   <li>Then builder build userId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationInstanceRecipient)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationInstanceRecipient) with 'AttestationInstanceRecipient'; then builder build userId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationInstanceRecipient)"})
  void testBuilderFromWithAttestationInstanceRecipient_thenBuilderBuildUserIdIs42() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
    AttestationInstanceRecipient instance = mock(AttestationInstanceRecipient.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.userId()).thenReturn("42");
    ImmutableAttestationInstance.Json json = new ImmutableAttestationInstance.Json();
    when(instance.attestationInstance()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).attestationInstance();
    verify(instance).userId();
    ImmutableAttestationInstanceRecipient buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertSame(json, buildResult.attestationInstance());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationInstanceRecipient)} with {@code AttestationInstanceRecipient}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationInstanceRecipient)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationInstanceRecipient) with 'AttestationInstanceRecipient'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationInstanceRecipient)"})
  void testBuilderFromWithAttestationInstanceRecipient_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
    AttestationInstanceRecipient instance = mock(AttestationInstanceRecipient.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.userId()).thenReturn("42");
    when(instance.attestationInstance()).thenReturn(new ImmutableAttestationInstance.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).attestationInstance();
    verify(instance).userId();
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
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
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
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
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
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
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
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

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
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#userId(String)}.
   * <p>
   * Method under test: {@link Builder#userId(String)}
   */
  @Test
  @DisplayName("Test Builder userId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userId(String)"})
  void testBuilderUserId() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Test Json {@link Json#attestationInstance()}.
   * <p>
   * Method under test: {@link Json#attestationInstance()}
   */
  @Test
  @DisplayName("Test Json attestationInstance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttestationInstance Json.attestationInstance()"})
  void testJsonAttestationInstance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestationInstance());
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
    assertNull(actualJson.userId);
    assertNull(actualJson.attestationInstance);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#userId()}.
   * <p>
   * Method under test: {@link Json#userId()}
   */
  @Test
  @DisplayName("Test Json userId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.userId()"})
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userId());
  }
}
