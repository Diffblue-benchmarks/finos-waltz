package org.finos.waltz.model.rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;

class RatingSchemeDiffblueTest {
  /**
   * Method under test: {@link RatingScheme#toList()}
   */
  @Test
  void testToList() {
    // Arrange and Act
    List<RatingSchemeItem> actualToListResult = RatingScheme.toList();

    // Assert
    assertEquals(6, actualToListResult.size());
    RatingSchemeItem getResult = actualToListResult.get(0);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    RatingSchemeItem getResult2 = actualToListResult.get(1);
    assertTrue(getResult2 instanceof ImmutableRatingSchemeItem);
    RatingSchemeItem getResult3 = actualToListResult.get(2);
    assertTrue(getResult3 instanceof ImmutableRatingSchemeItem);
    RatingSchemeItem getResult4 = actualToListResult.get(3);
    assertTrue(getResult4 instanceof ImmutableRatingSchemeItem);
    RatingSchemeItem getResult5 = actualToListResult.get(4);
    assertTrue(getResult5 instanceof ImmutableRatingSchemeItem);
    RatingSchemeItem getResult6 = actualToListResult.get(5);
    assertTrue(getResult6 instanceof ImmutableRatingSchemeItem);
    assertEquals("#28a1b6", getResult6.color());
    assertEquals("#2ca02c", getResult4.color());
    assertEquals("#786aa5", getResult.color());
    assertEquals("#d62728", getResult2.color());
    assertEquals("#eee", getResult5.color());
    assertEquals("#ff7f0e", getResult3.color());
    assertEquals("A", getResult3.rating());
    assertEquals("F", getResult.rating());
    assertEquals("G", getResult4.rating());
    assertEquals("R", getResult2.rating());
    assertEquals("X", getResult5.rating());
    assertEquals("Z", getResult6.rating());
    assertEquals("dflt - Disinvest", getResult2.description());
    assertEquals("dflt - Disinvest", getResult2.name());
    assertEquals("dflt - Future", getResult.description());
    assertEquals("dflt - Future", getResult.name());
    assertEquals("dflt - Invest", getResult4.description());
    assertEquals("dflt - Invest", getResult4.name());
    assertEquals("dflt - Maintain", getResult3.description());
    assertEquals("dflt - Maintain", getResult3.name());
    assertEquals("dflt - Not Applicable", getResult5.description());
    assertEquals("dflt - Not Applicable", getResult5.name());
    assertEquals("dflt - Unknown", getResult6.description());
    assertEquals("dflt - Unknown", getResult6.name());
    assertNull(getResult.ratingGroup());
    assertNull(getResult2.ratingGroup());
    assertNull(getResult3.ratingGroup());
    assertNull(getResult4.ratingGroup());
    assertNull(getResult5.ratingGroup());
    assertNull(getResult6.ratingGroup());
    assertEquals(10, getResult2.position());
    assertEquals(1L, getResult.ratingSchemeId());
    assertEquals(1L, getResult2.ratingSchemeId());
    assertEquals(1L, getResult3.ratingSchemeId());
    assertEquals(1L, getResult4.ratingSchemeId());
    assertEquals(1L, getResult5.ratingSchemeId());
    assertEquals(1L, getResult6.ratingSchemeId());
    assertEquals(20, getResult3.position());
    assertEquals(30, getResult4.position());
    assertEquals(35, getResult.position());
    assertEquals(40, getResult6.position());
    assertEquals(50, getResult5.position());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult2.isRestricted());
    assertFalse(getResult3.isRestricted());
    assertFalse(getResult4.isRestricted());
    assertFalse(getResult5.isRestricted());
    assertFalse(getResult6.isRestricted());
    assertFalse(getResult.requiresComment());
    assertFalse(getResult2.requiresComment());
    assertFalse(getResult3.requiresComment());
    assertFalse(getResult4.requiresComment());
    assertFalse(getResult5.requiresComment());
    assertFalse(getResult6.requiresComment());
    assertFalse(getResult6.userSelectable());
    assertTrue(getResult.userSelectable());
    assertTrue(getResult2.userSelectable());
    assertTrue(getResult3.userSelectable());
    assertTrue(getResult4.userSelectable());
    assertTrue(getResult5.userSelectable());
  }
}
