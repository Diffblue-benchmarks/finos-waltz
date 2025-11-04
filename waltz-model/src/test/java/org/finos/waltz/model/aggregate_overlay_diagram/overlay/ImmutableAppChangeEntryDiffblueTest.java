package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.finos.waltz.model.ChangeDirection;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableAppChangeEntryDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAppChangeEntry.Builder#appRef(EntityReference)}
   */
  @Test
  void testBuilderAppRef() {
    // Arrange
    ImmutableAppChangeEntry.Builder builderResult = ImmutableAppChangeEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeEntry.Builder#changeDirection(ChangeDirection)}
   */
  @Test
  void testBuilderChangeDirection() {
    // Arrange
    ImmutableAppChangeEntry.Builder builderResult = ImmutableAppChangeEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeDirection(ChangeDirection.INBOUND));
  }

  /**
   * Method under test: {@link ImmutableAppChangeEntry.Builder#date(LocalDate)}
   */
  @Test
  void testBuilderDate() {
    // Arrange
    ImmutableAppChangeEntry.Builder builderResult = ImmutableAppChangeEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.date(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeEntry.Builder#from(AppChangeEntry)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAppChangeEntry.Builder builderResult = ImmutableAppChangeEntry.builder();
    AppChangeEntry instance = mock(AppChangeEntry.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.date()).thenReturn(ofResult);
    when(instance.changeDirection()).thenReturn(ChangeDirection.INBOUND);
    when(instance.appRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableAppChangeEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appRef();
    verify(instance).changeDirection();
    verify(instance).date();
    ImmutableAppChangeEntry buildResult = builderResult.build();
    assertEquals(ChangeDirection.INBOUND, buildResult.changeDirection());
    assertSame(ofResult, buildResult.date());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeEntry.Builder#from(AppChangeEntry)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAppChangeEntry.Builder builderResult = ImmutableAppChangeEntry.builder();
    AppChangeEntry instance = mock(AppChangeEntry.class);
    when(instance.date()).thenThrow(new IllegalStateException("instance"));
    when(instance.changeDirection()).thenReturn(ChangeDirection.INBOUND);
    when(instance.appRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appRef();
    verify(instance).changeDirection();
    verify(instance).date();
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeEntry.Builder#from(AppChangeEntry)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAppChangeEntry.Builder builderResult = ImmutableAppChangeEntry.builder();
    AppChangeEntry instance = mock(AppChangeEntry.class);
    when(instance.changeDirection()).thenThrow(new IllegalStateException("instance"));
    when(instance.appRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appRef();
    verify(instance).changeDirection();
  }

  /**
   * Method under test: {@link ImmutableAppChangeEntry#copyOf(AppChangeEntry)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AppChangeEntry instance = mock(AppChangeEntry.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.date()).thenReturn(ofResult);
    when(instance.changeDirection()).thenReturn(ChangeDirection.INBOUND);
    when(instance.appRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableAppChangeEntry actualCopyOfResult = ImmutableAppChangeEntry.copyOf(instance);

    // Assert
    verify(instance).appRef();
    verify(instance).changeDirection();
    verify(instance).date();
    LocalDate dateResult = actualCopyOfResult.date();
    assertEquals("1970-01-01", dateResult.toString());
    assertEquals(ChangeDirection.INBOUND, actualCopyOfResult.changeDirection());
    assertSame(ofResult, dateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeEntry#fromJson(ImmutableAppChangeEntry.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAppChangeEntry.Json json = new ImmutableAppChangeEntry.Json();
    LocalDate date = LocalDate.of(1970, 1, 1);
    json.setDate(date);
    json.setChangeDirection(ChangeDirection.INBOUND);
    json.setAppRef(mock(EntityReference.class));

    // Act
    ImmutableAppChangeEntry actualFromJsonResult = ImmutableAppChangeEntry.fromJson(json);

    // Assert
    LocalDate dateResult = actualFromJsonResult.date();
    assertEquals("1970-01-01", dateResult.toString());
    assertEquals(ChangeDirection.INBOUND, actualFromJsonResult.changeDirection());
    assertSame(date, dateResult);
    EntityReference expectedAppRefResult = json.appRef;
    assertSame(expectedAppRefResult, actualFromJsonResult.appRef());
  }

  /**
   * Method under test: {@link ImmutableAppChangeEntry.Json#appRef()}
   */
  @Test
  void testJsonAppRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppChangeEntry.Json()).appRef());
  }

  /**
   * Method under test: {@link ImmutableAppChangeEntry.Json#changeDirection()}
   */
  @Test
  void testJsonChangeDirection() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppChangeEntry.Json()).changeDirection());
  }

  /**
   * Method under test: {@link ImmutableAppChangeEntry.Json#date()}
   */
  @Test
  void testJsonDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppChangeEntry.Json()).date());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAppChangeEntry.Json}
   *   <li>{@link ImmutableAppChangeEntry.Json#setAppRef(EntityReference)}
   *   <li>{@link ImmutableAppChangeEntry.Json#setChangeDirection(ChangeDirection)}
   *   <li>{@link ImmutableAppChangeEntry.Json#setDate(LocalDate)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAppChangeEntry.Json actualJson = new ImmutableAppChangeEntry.Json();
    actualJson.setAppRef(null);
    actualJson.setChangeDirection(ChangeDirection.INBOUND);
    actualJson.setDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals("1970-01-01", actualJson.date.toString());
  }
}
